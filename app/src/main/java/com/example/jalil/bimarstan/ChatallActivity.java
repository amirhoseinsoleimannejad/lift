package com.example.jalil.bimarstan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.jalil.bimarstan.otherclass.MessageAdapter;
import com.example.jalil.bimarstan.otherclass.message;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChatallActivity extends AppCompatActivity {


    private ListView listView;


    private List<message> listmessage;
    private MessageAdapter messageAdapter;

    private String text="";
    private Boolean start=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatall);


        MyApplication.activity=this;


        listView=(ListView) findViewById(R.id.list_message);
        listmessage = new ArrayList<message>();



        ImageView send= (ImageView) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                EditText ed=(EditText) findViewById(R.id.text_message);
                text=ed.getText().toString();


                message m=new message(text,"","",true,"");
                listmessage.add(m);

                messageAdapter = new MessageAdapter(MyApplication.activity,listmessage);
                listView.setAdapter(messageAdapter);

                HttpPostAsyncTask task = new HttpPostAsyncTask();
                task.execute(MyApplication.urlserver + "insert_message");

                ed.setText(null);

            }
        });






        new Thread( new Runnable() {
            @Override
            public void run() {


                while (start){

                    try {


                        Thread.sleep(10000);

                        HttpPostAsyncTask task = new HttpPostAsyncTask();
                        task.execute(MyApplication.urlserver + "fetch_message_all");



                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }


            }
        }).start();



        HttpPostAsyncTask task = new HttpPostAsyncTask();
        task.execute(MyApplication.urlserver + "fetch_message_all");


    }












    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {


        HttpPost httppost;
        HttpClient httpclient;
        List<NameValuePair> nameValuePairs;







        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);


            listmessage.clear();


            message m_array[];

            try {


                JSONArray contacts;
                JSONObject jsonObj = new JSONObject(result);
                contacts = jsonObj.getJSONArray("message_all");


                m_array=new message[contacts.length()];

                int k=contacts.length();
                for (int i = 0; i < contacts.length(); i++) {

                    JSONObject c = contacts.getJSONObject(i);
                    String text = c.getString("text");
                    String date = c.getString("date");
                    String time = c.getString("time");
                    String image = c.getString("img");
                    String id_user = c.getString("id_user");


                    k--;

                    SharedPreferences sharedpreferences = getSharedPreferences(MyApplication.MyPREFERENCES, Context.MODE_PRIVATE);

                    if(id_user.equals(sharedpreferences.getString(MyApplication.id_sick ,"-1"))){
                        message m=new message(text,date,time,true,image);
                        m_array[k]=m;

                    }
                    else{
                        message m=new message(text,date,time,false,image);
                        m_array[k]=m;
                    }


                }


                for (int i = 0; i < m_array.length; i++) {
                    listmessage.add(m_array[i]);
                }


                messageAdapter = new MessageAdapter(MyApplication.activity,listmessage);
                listView.setAdapter(messageAdapter);

            }
            catch (Exception e){


                Log.i("eeeeee", "errrrrrrrror: "+e.toString());
            }

        }






        @Override
        protected void onPreExecute() {


        }



        // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
        @Override
        protected String doInBackground(String... params) {

            try {


                Log.i("urluuuuuuuuuuuuuuu", "doInBackground: "+params[0]);

                httpclient=new DefaultHttpClient();
                httppost= new HttpPost(params[0]); // make sure the url is correct.
                //add your data

                Log.i("uuuuuu", "urluuuuuuuuuuuu "+params[0]);
                nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("message",text.trim()));

               SharedPreferences sharedpreferences = getSharedPreferences(MyApplication.MyPREFERENCES, Context.MODE_PRIVATE);

                nameValuePairs.add(new BasicNameValuePair("id_user", sharedpreferences.getString(MyApplication.id_sick ,"-1").trim()));

                nameValuePairs.add(new BasicNameValuePair("type","1".trim()));


//                Log.i("dddddddddd", "doInBackground: "+shpref.getString("id_user","-1").trim());
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String response = httpclient.execute(httppost, responseHandler);
                System.out.println("Response : " + response);
                return response;



            } catch (Exception e) {
                Log.i("error rrrrrrr", e.toString());
            }

            return "0";
        }
    }
}
