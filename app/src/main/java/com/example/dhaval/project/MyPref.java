package com.example.dhaval.project;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPref {
    SharedPreferences preferences;
    final static String MyPREFERENCES = "MySharedPref";

    private MyPref(SharedPreferences sharedPreferences){
        this.preferences=sharedPreferences;
    }

    public static MyPref getInstance(Context context) {
        return new MyPref(context.getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE));
    }

    public void put(String key,String value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
    }

}
