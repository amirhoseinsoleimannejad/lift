package com.example.jalil.bimarstan;



import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.jalil.bimarstan.otherclass.FontsOverride;


public class MyApplication extends Application {

    public static Context context;
    public static Activity activity;

//    public static String urlserver="http://www.darmlneh.com/android/";
//    public static String ServerImg="http://www.darmlneh.com/uploads/";
//    public static String urlwebview="http://www.darmlneh.com/";



    public static String urlserver="http://192.168.1.145/frontend/web/android/";
    public static String ServerImg="http://192.168.1.145/frontend/web/uploads/";
    public static String urlwebview="http://192.168.1.145/frontend/web/";
    public static String service="ws://192.168.1.145:9000";


    public static final String MyPREFERENCES = "MyPrefs";
    public static final String id_user = "id_user";
    public static final String id_sick = "id_user";
    public static final String code = "code";
    public static final String lang = "lang";





    public static final String CheckLoginUrl= MyApplication.urlserver+"auth";
    public static final String FetchlistCity= MyApplication.urlserver+"fetchlistcity";
    public static final String FetchlistOstan= MyApplication.urlserver+"fetchlistostan";
    public static final String FetchlistShahrestan= MyApplication.urlserver+"fetchlistshahrestan";
    public static final String FetchlistPart= MyApplication.urlserver+"fetchlistpart";
    public static final String FetchlistDoctor= MyApplication.urlserver+"fetchlistdoctor";
    public static final String FetchlistTurn= MyApplication.urlserver+"fetchlistturn";
    public static final String FetchlistDoctorAll= MyApplication.urlserver+"fetchlistdoctorall";

    public static final String Turn= MyApplication.urlserver+"turn";
    public static final String FetchListMmpi= MyApplication.urlserver+"fetchlistmmpi";
    public static final String FetchListVisit= MyApplication.urlserver+"fetchlistvisit";
    public static final String FetchListVisitAnswer= MyApplication.urlserver+"fetchlist_visit_answer";
    public static final String FetchListExpertise= MyApplication.urlserver+"fetchlistexpertise";




















    @Override
    public void onCreate() {

        context = getApplicationContext();
        super.onCreate();


        FontsOverride.setDefaultFont(context, "DEFAULT", "IRANSansWeb(FaNum).ttf");
        FontsOverride.setDefaultFont(context, "MONOSPACE", "IRANSansWeb(FaNum)_Bold.ttf");
        FontsOverride.setDefaultFont(context, "SERIF", "IRANSansWeb(FaNum)_Medium.ttf");
        FontsOverride.setDefaultFont(context, "SANS_SERIF", "IRANSansWeb(FaNum)_UltraLight.ttf");
        FontsOverride.setDefaultFont(context, "SANS_SERIF2", "Ebhaar.otf");



    }




}