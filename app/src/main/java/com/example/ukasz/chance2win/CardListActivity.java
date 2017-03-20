package com.example.ukasz.chance2win;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import com.example.ukasz.chance2win.App;

public class CardListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        ArrayAdapter<String> cardsAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.itemName, (ArrayList)App.deck.deckList);

        ListView cardsList = new ListView(this);
        setContentView(cardsList);
        cardsList.setAdapter(cardsAdapter);

    }
}
