package com.example.jalil.bimarstan;



import android.app.Activity;
import android.content.Intent;

import android.graphics.Typeface;
import android.os.Handler;

import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressLint("SetJavaScriptEnabled")
public class LogoActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        MyApplication.activity=this;




        final Animation a = AnimationUtils.loadAnimation(this, R.anim.animation_scale);
        a.reset();

        android.support.constraint.ConstraintLayout layout = (android.support.constraint.ConstraintLayout) findViewById(R.id.con_bg);
        layout.startAnimation(a);





        final Animation b = AnimationUtils.loadAnimation(this, R.anim.animation_alpha);
        b.reset();
        final TextView rText = (TextView) findViewById(R.id.des_logo);
        rText.startAnimation(b);



        Typeface yekan_font2 = Typeface.createFromAsset(getAssets(), "Ebhaar.otf");
        rText.setTypeface(yekan_font2);


        final Animation c = AnimationUtils.loadAnimation(this, R.anim.animation_translate);
        c.reset();
        final ImageView imgview = (ImageView) findViewById(R.id.imagelogo);
        imgview.startAnimation(c);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(MyApplication.activity,LoginActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.animation_activity_start,R.anim.animation_activity_end);
                finish();

            }
        },5000);

    }


}

