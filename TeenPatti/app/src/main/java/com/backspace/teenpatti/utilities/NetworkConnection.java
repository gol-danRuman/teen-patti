package com.backspace.teenpatti.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Backspace on 11/15/2016.
 */
public class NetworkConnection {
    boolean haveConnectedWifi = false;
    boolean haveConnectedMobile = false;
    Context mContext;

    public boolean haveNetworkConnection(Context context) {
        mContext=context;
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected()){
                    haveConnectedMobile = true;
                    Toast.makeText(mContext,"Using data can charge cost",Toast.LENGTH_LONG).show();
                }
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
