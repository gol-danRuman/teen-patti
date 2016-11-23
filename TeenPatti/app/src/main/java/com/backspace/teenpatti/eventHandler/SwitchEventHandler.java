package com.backspace.teenpatti.eventHandler;

import android.app.Activity;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.service.BackgroundSoundService;

/**
 * Created by Backspace on 11/15/2016.
 */
public class SwitchEventHandler {
    public void onPlayerModeSwitchClicked(CompoundButton buttonView, boolean isChecked, Activity activity){
        if(buttonView.getId()== R.id.switch_music){
            if (isChecked) {
                activity.startService(new Intent(activity,BackgroundSoundService.class));
                Toast.makeText(activity.getApplicationContext(),"Music Unmuted",Toast.LENGTH_SHORT).show();

            } else {

                activity.stopService(new Intent(activity,BackgroundSoundService.class));
                Toast.makeText(activity.getApplicationContext(),"Music Muted",Toast.LENGTH_SHORT).show();
            }
        }
        else if(buttonView.getId()==R.id.switch_sound){
            if (isChecked) {
            } else {
            }
        }
        else if(buttonView.getId()==R.id.switch_notify_me){
            if (isChecked) {
            } else {
            }
        }
    }
}
