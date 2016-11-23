package com.backspace.teenpatti.eventHandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.Toast;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.fragment.PlayerMode;
import com.backspace.teenpatti.game.GameDetails;
import com.backspace.teenpatti.interfaces.Restart;
import com.backspace.teenpatti.main.MainActivity;
import com.backspace.teenpatti.player.PlayerDetails;

/**
 * Created by Backspace on 11/15/2016.
 */
public class OverflowMenuEventHandler {
    private final Context context;
    private final Menu menu;
    Intent intent;
    Restart restart;

    public OverflowMenuEventHandler(Context context, Menu menu) {
        this.context=context;
        this.menu=menu;
    }
    //handling the menu Event from MainActivity
    public boolean onMainActivityMenuSelected(MenuItem item, PlayerMode playerMode){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //exit overflow menu handling
        if (id == R.id.action_exit) {
            System.exit(0);
            return true;
        }

        //night mode handling
        if (id == R.id.action_night_mode) {
            MenuItem menuItem = menu.findItem(R.id.action_night_mode);
            if (GameDetails.getNightmode()) {
                GameDetails.setNightmode(false);
                playerMode.nightmode(false);
                menuItem.setTitle("Night Mode");
            } else{
                GameDetails.setNightmode(true);
                playerMode.nightmode(true);
                menuItem.setTitle("Light Mode");
            }
            return true;
        }
        return true;
    }

    //MainActivity Menu event handling ends here


    //Setting menu event handling ends here
    public void onSettingMenuSelected(Activity activity,MenuItem item, EditText player1Edit, EditText player2Edit, EditText player3Edit, EditText player4Edit, PlayerDetails playerDetails) {
        switch (item.getItemId()) {
            case R.id.action_save:
                updateData(player1Edit,player2Edit,player3Edit,player4Edit,playerDetails);
                Toast.makeText(context, "Setting Changed", Toast.LENGTH_SHORT).show();
            case R.id.action_discard:
                FragmentManager fm = ((FragmentActivity) activity).getSupportFragmentManager();
                fm.popBackStack();
//                ((FragmentActivity) context).getFragmentManager().popBackStack();
                Toast.makeText(context, "Setting Discarded", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean updateData(EditText player1Edit, EditText player2Edit, EditText player3Edit, EditText player4Edit, PlayerDetails playerDetails) {
        String player1,player2,player3,player4;
        try {
            player1 = player1Edit.toString().trim();
            player2 = player2Edit.toString().trim();
            player3 = player3Edit.toString().trim();
            player4 = player4Edit.toString().trim();
            playerDetails.setPlayerName(player1, player2, player3, player4);
        }catch (NullPointerException ex){

        }finally {
            return true;
        }
    }
}
