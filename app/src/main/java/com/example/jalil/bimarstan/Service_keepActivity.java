package com.example.jalil.bimarstan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Service_keepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_keep);

    }





    public void azmon(View view) {

        YoYo.with(Techniques.Shake)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.reqest));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent jalil=new Intent(MyApplication.activity,List_service_keepActivity.class);
                startActivity(jalil);

            }
        },1000);


    }

}
