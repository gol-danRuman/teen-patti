package com.backspace.teenpatti.game;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.utilities.RandomGenerator;

/**
 * Created by Backspace on 11/21/2016.
 */
public class Cards {
    int cardImageDrawable[]={R.drawable.b02,R.drawable.b03,R.drawable.b04,R.drawable.b05,R.drawable.b06,R.drawable.b07,R.drawable.b08,R.drawable.b09,R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13,R.drawable.b14,
            R.drawable.c02,R.drawable.c03,R.drawable.c04,R.drawable.c05,R.drawable.c06,R.drawable.c07,R.drawable.c08,R.drawable.c09,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,
            R.drawable.h02,R.drawable.h03,R.drawable.h04,R.drawable.h05,R.drawable.h06,R.drawable.h07,R.drawable.h08,R.drawable.h09,R.drawable.h10,R.drawable.h11,R.drawable.h12,R.drawable.h13,R.drawable.h14,
            R.drawable.s02,R.drawable.s03,R.drawable.s04,R.drawable.s05,R.drawable.s06,R.drawable.s07,R.drawable.s08,R.drawable.s09,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14};
    int id[]={R.id.p10,R.id.p11,R.id.p12,R.id.p20,R.id.p21,R.id.p22,R.id.p30,R.id.p31,R.id.p32,R.id.p40,R.id.p41,R.id.p42};
    int rand[];

    ImageView cardImage[]=new ImageView[12];
    RandomGenerator generator;
    Activity activity;


    public Cards(Activity activity){
        this.activity=activity;
        generator=new RandomGenerator(activity);
       for(int i=0;i<12;i++){
           cardImage[i]= (ImageView) activity.findViewById(id[i]);
       }
    }
    public void showCard(){
       for (int i=0;i<12;i++){
           cardImage[i].setVisibility(View.VISIBLE);
       }
    }
    public void hideAllCards() {
        for (int i=0;i<12;i++){
            cardImage[i].setVisibility(View.INVISIBLE);
        }
    }
    public void setRandom(){

        for(int i=0;i<12;i++){
            rand[i]= RandomGenerator.getRandomIndex();
        }
    }
    public void showFace() {
//        showing face for first player
        generator=new RandomGenerator(activity.getApplicationContext());
        setRandom();
        for(int i=0;i<12;i++){
            cardImage[i].setImageResource(cardImageDrawable[rand[i]]);
        }
    }

}
