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


public class ProductAdapter extends ArrayAdapter<dragestor> {

    private final Activity context;
    private final List<dragestor>  itemname;

    public ProductAdapter(Activity context, List<dragestor> itemname) {
        super(context, R.layout.listproduct, itemname);
        this.context=context;
        this.itemname=itemname;
    }




    public View getView(final int position, View view, ViewGroup parent) {




        View listItem = view;
        MyWrapper wrapper = null;


        try {

            if (listItem == null) {

                listItem = LayoutInflater.from(context).inflate(R.layout.listproduct, parent, false);
                wrapper = new MyWrapper(listItem);
                listItem.setTag(wrapper);

            } else {
                wrapper = (MyWrapper) listItem.getTag();
            }


            wrapper.getTitle().setText(itemname.get(position).getText());
            wrapper.getPrice().setText(itemname.get(position).getAddress());
            wrapper.getDescription().setText(itemname.get(position).getMobile());
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
        private TextView title;
        private TextView price;
        private TextView qty;
        private TextView description;
        private Button payment;

        public MyWrapper(View base)
        {
            this.base = base;
        }



        public TextView getTitle(){
            if(title == null){
                title = (TextView) base.findViewById(R.id.title);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                text .setTypeface(yekan_font);

            }
            return title;
        }






        public TextView getQty(){
            if(qty == null){
                qty = (TextView) base.findViewById(R.id.qty);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                mobile .setTypeface(yekan_font);

            }
            return qty;
        }





        public TextView getDescription(){
            if(description == null){
                description = (TextView) base.findViewById(R.id.description);
//                Typeface yekan_font = Typeface.createFromAsset(MyApplication.activity.getAssets(), "B Nazanin Bold_p30download.com.ttf");
//                address .setTypeface(yekan_font);

            }
            return description;
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
