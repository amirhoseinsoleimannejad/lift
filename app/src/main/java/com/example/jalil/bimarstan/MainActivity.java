package com.example.jalil.bimarstan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        MyApplication.activity=this;

        SharedPreferences sharedpreferences = getSharedPreferences(MyApplication.MyPREFERENCES, Context.MODE_PRIVATE);



//        String checklogin = sharedpreferences.getString(MyApplication.id_user ,"-1");
//        if(checklogin.equals("-1") ) {
//            Intent myIntent = new Intent(MyApplication.activity,LoginActivity.class);
//            startActivity(myIntent);
//            finish();
//        }








        Button backbutton=(Button) findViewById(R.id.button2);
        backbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                MyApplication.activity.finish();
            }
        });




        Calendar c = Calendar.getInstance();
        System.out.println("Current time =&gt; "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
// Now formattedDate have current date/time
//        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();
        TextView d=( TextView )findViewById(R.id.textView44);
        String d_t[]=formattedDate.split(" ");
        d.setText(d_t[1]);
        TextView d1=( TextView )findViewById(R.id.textView45);

        d1.setText(d_t[0]);
    }




    @Override
    protected void onStop()
    {
        super.onStop();

    }







    public void azmon(View view) {

        YoYo.with(Techniques.Shake)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.service_keep));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent jalil=new Intent(MyApplication.activity,Service_keepActivity.class);
                startActivity(jalil);

            }
        },1000);


    }





    public void takeprice(View view) {

        YoYo.with(Techniques.Shake)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.request_price));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent jalil=new Intent(MyApplication.activity,Take_price_leftActivity.class);
                startActivity(jalil);

            }
        },1000);


    }








    public void requestfix(View view) {

        YoYo.with(Techniques.Shake)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.request_service));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent jalil=new Intent(MyApplication.activity,Request_fixActivity.class);
                startActivity(jalil);

            }
        },1000);


    }












    public void products(View view) {

        YoYo.with(Techniques.Shake)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.products));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent jalil=new Intent(MyApplication.activity,List_productsActivity.class);
                startActivity(jalil);

            }
        },1000);


    }
}
