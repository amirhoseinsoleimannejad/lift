package com.example.jalil.bimarstan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.jalil.bimarstan.otherclass.DragestorAdapter;
import com.example.jalil.bimarstan.otherclass.dragestor;

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

public class List_service_keepActivity extends AppCompatActivity {


    public ListView lv_dragestor;
    public List<dragestor> listdragestor;
    public DragestorAdapter dragestoradapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_keep_list);


        lv_dragestor=(ListView)findViewById(R.id.list_visitor);
        listdragestor=new ArrayList<dragestor>();

        dragestoradapter = new DragestorAdapter(MyApplication.activity,listdragestor);
        lv_dragestor.setAdapter(dragestoradapter);


        dragestor v=new dragestor("1","طبقات","توقف","مدت","قیمت","","");
        listdragestor.add(v);



        HttpPostAsyncTask task = new HttpPostAsyncTask();
        task.execute(MyApplication.urlserver + "list_service_keep");
    }













    public class HttpPostAsyncTask extends AsyncTask<String, String, String> {


        HttpPost httppost;
        HttpClient httpclient;
        List<NameValuePair> nameValuePairs;







        @Override
        protected void onPostExecute(String result) {

            Log.i("22222222222222222", "22222222222222222222222222" + result);






            try {


                JSONArray contacts;
                JSONObject jsonObj = new JSONObject(result);
                contacts = jsonObj.getJSONArray("service");




                int k=contacts.length();
                for (int i = 0; i < contacts.length(); i++) {

                    JSONObject c = contacts.getJSONObject(i);
                    String id = c.getString("id");
                    String floornamber = c.getString("floornamber");
                    String numderstop = c.getString("numderstop");
                    String duration = c.getString("duration");
                    String price = c.getString("price");

                    dragestor v=new dragestor(id,floornamber,numderstop,duration,price,"","");
                    listdragestor.add(v);
                }



//                dragestoradapter = new DragestorAdapter(MyApplication.activity,listdragestor);
//                lv_dragestor.setAdapter(dragestoradapter);


                dragestoradapter.notifyDataSetChanged();

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
                nameValuePairs = new ArrayList<NameValuePair>(1);


                SharedPreferences sharedpreferences = getSharedPreferences(MyApplication.MyPREFERENCES, Context.MODE_PRIVATE);
                nameValuePairs.add(new BasicNameValuePair("id_sick", sharedpreferences.getString(MyApplication.id_sick ,"-1").trim()));

                Log.i("111111111111", "11111111111111: "+sharedpreferences.getString(MyApplication.id_sick ,"-1").trim());
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
