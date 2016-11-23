package com.backspace.teenpatti.eventHandler;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.SwipeTab.TabFragment;
import com.backspace.teenpatti.fragment.AboutApp;
import com.backspace.teenpatti.fragment.Developer;
import com.backspace.teenpatti.fragment.Guide;
import com.backspace.teenpatti.fragment.MyProfile;
import com.backspace.teenpatti.fragment.PlayerMode;
import com.backspace.teenpatti.fragment.Setting;

/**
 * Created by Backspace on 11/15/2016.
 */
public class NavigationEventHandler {
    private final Context context;
    private final Menu menu;
    private final PlayerMode playerMode;

    public NavigationEventHandler(Context context, Menu menu, PlayerMode playerMode) {
        this.context=context;
        this.menu=menu;
        this.playerMode=playerMode;

    }

    //handling Navigation Drawer events
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) { // Handle the home navigation action
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,playerMode, "homeNeq");
            fragmentTransaction.addToBackStack("homeNer");
            fragmentTransaction.commit();
            return true;
        } else if (id == R.id.nav_setting) {
            try {

                FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, new Setting(), "settingFragment");
                fragmentTransaction.addToBackStack("SettingFragment");
                fragmentTransaction.commit();
            }catch (Exception e){

            }
        } else if (id == R.id.nav_highscore) {
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, new MyProfile(), "TabFragment");
            fragmentTransaction.addToBackStack("tabFragment");
            fragmentTransaction.commit();
            return true;

        } else if (id == R.id.nav_guide) {
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, new Guide(), "guide");
            fragmentTransaction.addToBackStack("guide");
            fragmentTransaction.commit();
            return true;

        } else if (id == R.id.nav_faq_facts) {
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, new TabFragment(), "faq/facts");
            fragmentTransaction.addToBackStack("guide");
            fragmentTransaction.commit();
            return true;

        } else if (id == R.id.nav_developer) {
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, new Developer(), "developer");
            fragmentTransaction.addToBackStack("developer");
            fragmentTransaction.commit();
            return true;
        }else if (id == R.id.nav_about_app) {
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, new AboutApp(), "aboutApp");
            fragmentTransaction.addToBackStack("aboutApp");
            fragmentTransaction.commit();
            return true;
        }

        return true;


    }
}
