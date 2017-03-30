package com.example.ukasz.chance2win;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.ImageButton;

/**
 * Created by Łukasz on 20.03.2017.
 */

public final class App extends Application {
    public static final String PREFS_NAME = "dataFile";
    public final static Deck deck = new Deck();
    public static Integer currentClicked = null;
    public static int currentResourceId;

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }


}
