package com.example.jalil.bimarstan.otherclass;


import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jalil.bimarstan.MyApplication;
import com.example.jalil.bimarstan.R;

import java.util.List;


public class DragestorAdapter extends ArrayAdapter<dragestor> {

    private final Activity context;
    private final List<dragestor>  itemname;

    public DragestorAdapter(Activity context, List<dragestor> itemname) {
        super(context, R.layout.listdragestor, itemname);
        this.context=context;
        this.itemname=itemname;
    }




    public View getView(final int position, View view, ViewGroup parent) {




        View listItem = view;
        MyWrapper wrapper = null;


        try {

            if (listItem == null) {

                listItem = LayoutInflater.from(context).inflate(R.layout.listdragestor, parent, false);
                wrapper = new MyWrapper(listItem);
                listItem.setTag(wrapper);

            } else {
                wrapper = (MyWrapper) listItem.getTag();
            }


            wrapper.getText().setText(itemname.get(position).getText());
            wrapper.getAddress().setText(itemname.get(position).getAddress());
            wrapper.getMobile().setText(itemname.get(position).getMobile());
            wrapper.getPrice().setText(itemname.get(position).getLat());





            wrapper.getPayment().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MyApplication.activity,"اتصال به درگاه",Toast.LENGTH_SHORT).show();
                }
            });




        }
        catch (Exception e){
            Log.i("eeeeee", "eeeeeeeeeeeeeeee"+e.toString());
        }



        return listItem;


    };







    class MyWrapper
    {
        private View base;
        private TextView text;
        private TextView mobile;
        private TextView address;
        private TextView price;
        private Button payment;

        public MyWrapper(View base)
        {
            this.base = base;
        }



        public TextView getText(){
            if(text == null){
                text = (TextView) base.findViewById(R.id.text);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                text .setTypeface(yekan_font);

            }
            return text;
        }






        public TextView getMobile(){
            if(mobile == null){
                mobile = (TextView) base.findViewById(R.id.mobile);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                mobile .setTypeface(yekan_font);

            }
            return mobile;
        }





        public TextView getAddress(){
            if(address == null){
                address = (TextView) base.findViewById(R.id.address);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                address .setTypeface(yekan_font);

            }
            return address;
        }



        public TextView getPrice(){
            if(price == null){
                price = (TextView) base.findViewById(R.id.price);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                address .setTypeface(yekan_font);

            }
            return price;
        }





        public Button getPayment(){
            if(payment == null){
                payment = (Button) base.findViewById(R.id.payment);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                address .setTypeface(yekan_font);

            }
            return payment;
        }
    }
}
