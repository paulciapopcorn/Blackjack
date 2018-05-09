package com.example.macair.jocppa;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by macair on 4/29/18.
 */

public class Card {
  private int image;
    private int value;


    public Card(int image,int value){
        this.value=value;
        this.image=image;
    }



    public int getImage(){
        return this.image;
    }

    public int getValue(){
        return this.value;
    }


}
