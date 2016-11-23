package com.backspace.teenpatti.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.game.GameDetails;
import com.backspace.teenpatti.main.TeenPatti;

/**
 * Created by Backspace on 11/11/2016.
 */
public class PlayerMode extends Fragment {

    //declaring all the widgets here
    Button singlePlayer, multiplayer;
    RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Binding the fragment class 'playermode' with its fragment layout 'fragment_player_mode
        return inflater.inflate(R.layout.fragment_player_mode, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //define all the widgets here
        relativeLayout = (RelativeLayout) getActivity().findViewById(R.id.mainLayout);

        //check if the setting is night mode
        nightmode(GameDetails.getNightmode());
        super.onActivityCreated(savedInstanceState);
    }

    public void nightmode(boolean flag) {
        if (flag) relativeLayout.setBackgroundResource(R.drawable.night_mode);
        else relativeLayout.setBackgroundResource(R.drawable.light_mode);
    }


}
