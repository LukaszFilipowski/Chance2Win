package com.example.ukasz.chance2win;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CardListActivity extends AppCompatActivity {

    ListView cardsList;
    boolean clicked = false;
    String[] cardNames = App.getStringFromResource(App.deck.getCardNamesId());
    Integer[] cardImagesId = App.deck.getCardImagesId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        CardListAdapter cardsAdapter = new CardListAdapter(CardListActivity.this, cardNames, cardImagesId);

        cardsList = (ListView)findViewById(R.id.cardList);
        cardsList.setAdapter(cardsAdapter);
        cardsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                App.currentResourceId = cardImagesId[position];
                clicked = true;
                App.deck.deleteFromDeck(cardImagesId[position]);
                Intent intent = new Intent(App.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
