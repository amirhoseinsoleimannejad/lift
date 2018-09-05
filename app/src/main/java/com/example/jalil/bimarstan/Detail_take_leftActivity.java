package com.example.jalil.bimarstan;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail_take_leftActivity extends FragmentActivity{


    public String detail;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_take_price);


        MyApplication.activity=this;
        Bundle bundle = getIntent().getExtras();
        detail=bundle.getString("detail");




        String split_detail[]=detail.split("#");
        String liftType=split_detail[0];
        String motortype=split_detail[1];
        String instalLocation=split_detail[2];
        String text=split_detail[3];
        String motor1=split_detail[4];
        String motor2=split_detail[5];
        String motor3=split_detail[6];
        String description1=split_detail[7];
        String description2=split_detail[8];
        String description3=split_detail[9];
        String description4=split_detail[10];
        String description5=split_detail[11];
        String description6=split_detail[12];









        TextView liftTypeT=(TextView) findViewById(R.id.liftType);
        liftTypeT.setText(liftType);

        TextView motortypeT=(TextView) findViewById(R.id.motortype);
        motortypeT.setText(motortype);


         TextView instalLocationT=(TextView) findViewById(R.id.instalLocation);
        instalLocationT.setText(instalLocation);



        TextView textT=(TextView) findViewById(R.id.text);
        textT.setText(text);








        TextView motor1T=(TextView) findViewById(R.id.motor1);
        motor1T.setText(motor1);






        TextView motor2T=(TextView) findViewById(R.id.motor2);
        motor2T.setText(motor2);





        TextView motor3T=(TextView) findViewById(R.id.motor3);
        motor3T.setText(motor3);





        TextView description1T=(TextView) findViewById(R.id.description1);
        description1T.setText(description1);



        TextView description2T=(TextView) findViewById(R.id.description2);
        description2T.setText(description2);



        TextView description3T=(TextView) findViewById(R.id.description3);
        description3T.setText(description3);



        TextView description4T=(TextView) findViewById(R.id.description4);
        description4T.setText(description4);



        TextView description5T=(TextView) findViewById(R.id.description5);
        description5T.setText(description5);




        TextView description6T=(TextView) findViewById(R.id.description6);
        description6T.setText(description6);





    }




}
