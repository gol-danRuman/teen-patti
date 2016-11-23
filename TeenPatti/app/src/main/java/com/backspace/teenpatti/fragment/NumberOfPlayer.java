package com.backspace.teenpatti.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.game.GameDetails;
import com.backspace.teenpatti.main.TeenPatti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Backspace on 11/18/2016.
 */
public class NumberOfPlayer extends Fragment implements View.OnClickListener{
    List<String> spinItem = new ArrayList<String>();
    Spinner spin;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_number_of_player, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int numberOfPLayer=1;
        if(v.getId()==R.id.twoPlayer){
            numberOfPLayer=2;
        }else if(v.getId()==R.id.threePlayers){
            numberOfPLayer=3;
        }else if(v.getId()==R.id.fourPlayers){
            numberOfPLayer=4;
        }
        GameDetails.setNumberOfPlayers(numberOfPLayer);
        startActivity(new Intent(getActivity().getApplicationContext(), TeenPatti.class)); //jump to main Game
    }

}
