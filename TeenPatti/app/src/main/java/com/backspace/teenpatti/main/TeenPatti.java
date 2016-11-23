package com.backspace.teenpatti.main;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.game.Cards;
import com.backspace.teenpatti.utilities.RandomGenerator;

/**
 * Created by Backspace on 11/18/2016.
 */
public class TeenPatti extends Activity implements View.OnClickListener{
    Cards cards;
    Drawable drawableTopShow;
    boolean shown=true;
    Drawable drawableTopPlay ;
    ImageView i10,i11,i12,i20,i21,i22,i30,i31,i32,i40,i41,i42;

    Button playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            setContentView(R.layout.teen_patti);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }

        //declaring all widget here
        cards=new Cards(this);
        drawableTopShow = getResources().getDrawable(R.drawable.show);
        drawableTopPlay = getResources().getDrawable(R.drawable.play);
        playButton= (Button) findViewById(R.id.play);
        cards.hideAllCards();
        playButton.setOnClickListener(this);
    }





    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.play) {
            if(playButton.getText().equals("Play")){

                if(shown)
                    cards.showCard();
                playButton.setText("Show");
                playButton.setCompoundDrawablesWithIntrinsicBounds(null, drawableTopShow , null, null);
            }else if(playButton.getText().equals("Show")){
                    cards.showFace();
                    playButton.setText("Play");
                    playButton.setCompoundDrawablesWithIntrinsicBounds(null, drawableTopPlay , null, null);
                    shown=false;

            }

        }
    }


}
