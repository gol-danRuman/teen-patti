package com.backspace.teenpatti.main;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Backspace on 11/9/2016.
 */
public class Message {

    static public void showToast(Context context, String message,int duration){
        Toast.makeText(context,message,duration).show();
    }
}
