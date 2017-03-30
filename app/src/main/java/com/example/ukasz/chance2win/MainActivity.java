package com.example.ukasz.chance2win;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(App.currentClicked != null) {

            SharedPreferences settings = getSharedPreferences(App.PREFS_NAME, 0);
            int selectedCount = settings.getInt("selectedCount", 0);
            selectedCount++;
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("Res"+selectedCount, App.currentResourceId);
            editor.putInt("selectedCount", selectedCount);
            editor.putInt("Btn"+selectedCount, App.currentClicked);
            editor.commit();

            App.currentClicked = null;
        }

        SharedPreferences settings = getSharedPreferences(App.PREFS_NAME, 0);
        int selectedCount = settings.getInt("selectedCount", 0);
        for(int i = 1; i <= selectedCount; i++ ) {
            int currentBtn = settings.getInt("Btn"+i, 0);
            if(currentBtn != 0) {
                int currentKey = settings.getInt("Res"+i, 0);
                if(currentKey != 0) {
                    ImageButton btn = (ImageButton) findViewById(currentBtn);
                    Picasso.with(this).load(currentKey).resize(115, 140).into(btn);
                }
            }
        }
    }

    public void selectCard(View view) {
        App.currentClicked = view.getId();
        Intent intent = new Intent(this, CardListActivity.class);
        startActivity(intent);
    }


}
