package com.example.jalil.bimarstan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Take_fixActivity extends AppCompatActivity {
    public static WebSocketClient mWebSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takefix);

        MyApplication.activity=this;

        URI uri;


        try {
            uri = new URI(MyApplication.service);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri, new Draft_17()) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Open" );


                mWebSocketClient.send("1895");

            }

            @Override
            public void onMessage(String s) {
                final String message = s;


                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {





                        if(message.equals("1")){
                            TextView tx=(TextView) findViewById(R.id.name_fix_person);
                            tx.setText(R.string.fix_person);
                        }
                        else if(message.equals("0")){

                        }

                    }
                });





            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };


        try {
            mWebSocketClient.connect();
        }
        catch (Exception a){

        }



    }









//
//
//    public void send_message(View view) {
//
//
//
//
//        Intent jalil=new Intent(this,ChatallActivity.class);
//        startActivity(jalil);
//        MyApplication.activity.finish();
//
//    }
//
//
//
//
//
//
//
//    public void cancel(View view) {
//
//
//
//        Intent jalil1=new Intent(this,MainActivity.class);
//        startActivity(jalil1);
//        MyApplication.activity.finish();
//
//    }








}
