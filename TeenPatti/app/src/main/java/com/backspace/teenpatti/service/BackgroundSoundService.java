package com.backspace.teenpatti.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.backspace.teenpatti.R;

/**
 * Created by Backspace on 11/16/2016.
 */
public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //targetting the file
        player = MediaPlayer.create(this, R.raw.bg_music);
        player.setLooping(true); // Set looping
        player.setVolume(100,100); //setting volume

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

    public void onStart(Intent intent, int startId) {
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }
    public void onStop() {

    }

    public void onPause() {


    }
    @Override
    public void onDestroy() {
        if(player!=null) {
            if(player.isPlaying())
                player.stop();
            player.reset();
            player.release();
            player=null;
        }
    }

    @Override
    public void onLowMemory() {

    }


}