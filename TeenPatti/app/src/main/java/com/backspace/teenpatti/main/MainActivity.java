package com.backspace.teenpatti.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.eventHandler.NavigationEventHandler;
import com.backspace.teenpatti.eventHandler.OverflowMenuEventHandler;
import com.backspace.teenpatti.fragment.NumberOfPlayer;
import com.backspace.teenpatti.fragment.PlayerMode;
import com.backspace.teenpatti.game.GameDetails;
import com.backspace.teenpatti.service.BackgroundSoundService;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Menu menu;
    PlayerMode playerMode;
    DrawerLayout drawer;
    Button singlePlayer,multiplayer;
    Switch music, notify, sound;
    Intent svc;
    NavigationEventHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //


        // setting up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // defining widget here...
        singlePlayer = (Button) findViewById(R.id.singlePlayerButton); //pointing to singlePlayer Button from java
        multiplayer = (Button) findViewById(R.id.mulPlayerButton); //pointing to multiplayer button from java

        music = (Switch) findViewById(R.id.switch_music);
        sound = (Switch) findViewById(R.id.switch_sound);
        notify = (Switch) findViewById(R.id.switch_notify_me);


        //defining the objects here
        handler=new NavigationEventHandler(this,menu,playerMode);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout); // set the navigation Drawer here
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); // set the navigation view here

        //defining classes here
        playerMode = new PlayerMode();

        //defining the services to play background music
        svc = new Intent(this, BackgroundSoundService.class);

        //creating the open close navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

//       etting fragment 'player mode' into main Activity
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.content_frame, playerMode, "frag a");
        fragmentTransaction.commit();

        startService(svc); // starting the background music
    }

    //when mainActivity paused, stop the bacground music too
    @Override
    protected void onPause() {
        super.onPause();
        stopService(svc); //stop service here(destroying service object)
    }



    @Override
    public boolean onCreateOptionsMenu(Menu men) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = men;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // call the function to handle the overflow menu events
        new OverflowMenuEventHandler(this, menu).onMainActivityMenuSelected(item, playerMode);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        return super.onCreateView(name, context, attrs);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(!drawer.equals(null))
            new NavigationEventHandler(this,menu,new PlayerMode()).onNavigationItemSelected(item);

        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }


    public void onClickMode(View v) {
        if(v.getId()==R.id.singlePlayerButton){
            GameDetails.setNumberOfPlayers(1);
            startActivity(new Intent(getApplicationContext(), TeenPatti.class)); //jump to player mode after 5 seconds

        }
        else if(v.getId()==R.id.mulPlayerButton){
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.content_frame,new NumberOfPlayer(),"nof");
            transaction.addToBackStack("nop");
            transaction.commit();


        }
    }
}
