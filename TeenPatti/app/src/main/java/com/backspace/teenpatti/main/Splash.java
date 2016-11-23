package com.backspace.teenpatti.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import com.backspace.teenpatti.R;

import java.io.File;


/**
 * Created by Backspace on 10/9/2016.
 *
 */
public class Splash extends Activity {
    private static final String DIRECOTRY_NAME="TeenPatti";
    private static final String INTERNAL_DIRECTORY_NAME = "/storage/emulated/0/"+DIRECOTRY_NAME;
    private static final String EXTERNAL_DIRECTORY_NAME = "/sdcard/"+DIRECOTRY_NAME;

    private static final String PATH = Environment.getDataDirectory().getAbsolutePath().toString() + INTERNAL_DIRECTORY_NAME;
    String[] loadingStringArray = null;
    TextView loadingSections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        createFolder();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //work here

                    sleep(4000);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class)); //jump to player mode after 5 seconds
                    finish();//terminate thread

                } catch (Exception e) {
                    e.printStackTrace(); //if sleep throws any exception
                }
            }
        };
        thread.start(); //call the thread
    }

    //methods to create a new Directory
    private void createFolder() {
        boolean success=false;
        File mFolder = new File(PATH);
        if (!mFolder.exists()) {
            success=mFolder.mkdir();
        }
        if(success) Toast.makeText(this,"Folder Created in "+INTERNAL_DIRECTORY_NAME+"successfully",Toast.LENGTH_LONG).show();
        File Directory = new File(EXTERNAL_DIRECTORY_NAME);
        success=Directory.mkdirs();
        if(success) Toast.makeText(this,"Folder Created in "+EXTERNAL_DIRECTORY_NAME+"successfully",Toast.LENGTH_LONG).show();
    }
}


