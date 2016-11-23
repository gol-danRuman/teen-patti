package com.backspace.teenpatti.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.eventHandler.OverflowMenuEventHandler;
import com.backspace.teenpatti.eventHandler.SwitchEventHandler;
import com.backspace.teenpatti.game.GameDetails;
import com.backspace.teenpatti.player.PlayerDetails;
import com.backspace.teenpatti.utilities.NetworkConnection;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Backspace on 11/13/2016.
 */
public class Setting extends Fragment implements CompoundButton.OnCheckedChangeListener{

    protected FragmentActivity mActivity;
    Menu menu;

    PlayerDetails playerDetails;
    GameDetails gameDetails;

    private TextView mTextDetails,facebookDetails;
    EditText player1Edit,player2Edit,player3Edit,player4Edit;
    RelativeLayout relativeLayout;

    Switch music,sound,notify;
    //constructor
    public Setting() {
        setHasOptionsMenu(true);
    }

    //for facebook login credential
    private CallbackManager mCallbackManager;
    private FacebookCallback<LoginResult> mCallback=new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {         //when fb account login successfully
            AccessToken accessToken=loginResult.getAccessToken();
            Profile profile=Profile.getCurrentProfile();
            if(profile!=null){
                facebookDetails.setText(profile.getLastName()+" "+ profile.getFirstName()+" :"); //by using profile class we can use image uri,name etc
                GameDetails.setFbConnected(true);
                gameDetails.setFbProfileName(profile.getName());

            }
        }

        @Override
        public void onCancel() {                        //when fb account got logout
            facebookDetails.setText("Login to Facebook");
            GameDetails.setFbConnected(false);
            gameDetails.setFbProfileName("");

        }

        @Override   //if something went wrong
        public void onError(FacebookException error) {
            facebookDetails.setText("Error on Connecting");

        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext()); //providing Context to FB login page
        mCallbackManager= CallbackManager.Factory.create();

    }

    @Override
    public void onCreateOptionsMenu(Menu men, MenuInflater inflater) {
        menu=men;
        menu.clear();
        inflater.inflate(R.menu.menu, menu); //creating overflowing menu
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new OverflowMenuEventHandler(getActivity().getApplicationContext(),menu).onSettingMenuSelected(getActivity(),item,player1Edit,player2Edit,player3Edit,player4Edit,playerDetails);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (FragmentActivity) activity;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);

    }
    //getting refrences
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        player1Edit = (EditText) getActivity().findViewById(R.id.editTextPlayer1);
        player2Edit = (EditText) getActivity().findViewById(R.id.editTextPlayer2);
        player3Edit = (EditText) getActivity().findViewById(R.id.editTextPlayer3);
        player4Edit = (EditText) getActivity().findViewById(R.id.editTextPlayer4);

        facebookDetails=(TextView) getActivity().findViewById(R.id.details);
        relativeLayout= (RelativeLayout) getActivity().findViewById(R.id.settingMain);
        LinearLayout first= (LinearLayout) getActivity().findViewById(R.id.firstLinearLayout);
        LinearLayout second= (LinearLayout) getActivity().findViewById(R.id.secondLinearLayout);
        //setting up the switch button
        music= (Switch) getActivity().findViewById(R.id.switch_music);
        sound= (Switch) getActivity().findViewById(R.id.switch_sound);
        notify= (Switch) getActivity().findViewById(R.id.switch_notify_me);
        //registering the switch button
        music.setOnCheckedChangeListener(this);
        sound.setOnCheckedChangeListener(this);
        notify.setOnCheckedChangeListener(this);
        //checking for night mode or light mode
        try{
            if (GameDetails.getNightmode()) {
                relativeLayout.setBackgroundResource(R.drawable.night_mode);
                first.setBackgroundColor(getResources().getColor(R.color.text_icons));
                second.setBackgroundColor(getResources().getColor(R.color.text_icons));
            }
            else {
                relativeLayout.setBackgroundResource(R.drawable.light_mode);
                first.setBackgroundColor(Color.TRANSPARENT);
                second.setBackgroundColor(Color.TRANSPARENT);
            }
        }catch (NullPointerException e){

        }
        //connecting apps to facebook
        LoginButton loginButton= (LoginButton) view.findViewById(R.id.connectToFacebook);
        NetworkConnection connection=new NetworkConnection();
        loginButton.setReadPermissions("email");
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager,mCallback);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        new SwitchEventHandler().onPlayerModeSwitchClicked(buttonView,isChecked,getActivity());
    }

}
