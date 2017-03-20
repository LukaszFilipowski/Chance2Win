package com.example.ukasz.chance2win;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import com.example.ukasz.chance2win.App;

public class CardListActivity extends AppCompatActivity {

    private String[] getStringFromResource(Integer[] stringIds) {
        String[] cardNames = new String[stringIds.length];
        for(int i=0; i<stringIds.length; i++) {
            cardNames[i] = getResources().getString(stringIds[i]);
        }

        return cardNames;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        String[] cardNames = getStringFromResource(App.deck.getCardNamesId());
        Integer[] cardImagesId = App.deck.getCardImagesId();

        CardListAdapter cardsAdapter = new CardListAdapter(CardListActivity.this, cardNames, cardImagesId);

        ListView cardsList = new ListView(this);
        setContentView(cardsList);
        cardsList.setAdapter(cardsAdapter);

    }
}
