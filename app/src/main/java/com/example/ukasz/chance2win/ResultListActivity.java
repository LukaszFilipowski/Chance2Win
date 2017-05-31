package com.example.ukasz.chance2win;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResultListActivity extends AppCompatActivity {

    ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int[] handCards = intent.getIntArrayExtra("handCards");
        int[] tableCards = intent.getIntArrayExtra("tableCards");

        int[] resourcesId = new int[handCards.length + tableCards.length];

        int n = 0;
        for(int i = 0; i < handCards.length; i++) {
            resourcesId[n] = handCards[i];
            n++;
        }

        for(int i = 0; i < tableCards.length; i++) {
            resourcesId[n] = tableCards[i];
            n++;
        }

        Poker userPoker = new Poker(resourcesId);

        Deck otherCardsDeck = new Deck(resourcesId);
        Integer[] cards = otherCardsDeck.getCardImagesId();

        List<String> handTypeList = new ArrayList<String>();
        LinkedList<Integer[]> selectedPairs = new LinkedList<Integer[]>();
        int createdObjects = 0;

        int allHands = 0, winHands = 0, drawHands = 0;
        for(int i = 0; i < cards.length; i++) {
            for(int l = i; l < cards.length; l++) {
                if (i != l) {

                    allHands++;
                    int[] selectedPair = new int[7];
                    selectedPair[0] = cards[i];
                    selectedPair[1] = cards[l];

                    for(int o = 2; o < selectedPair.length; o++) {
                        selectedPair[o] = tableCards[o-2];
                    }
                    Poker poker = new Poker(selectedPair);

                    int compare = userPoker.compare(poker);
                    if(compare == 0) {
                        winHands++;
                        selectedPairs.push(new Integer[]{cards[i], cards[l]});
                        handTypeList.add(poker.getHandType());
                    } else {
                        if(compare == 2) {
                            drawHands++;
                        }
                    }

                }
            }
        }

        ImageView card = (ImageView) findViewById(R.id.handCard);
        Picasso.with(this).load(handCards[0]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) findViewById(R.id.handCard2);
        Picasso.with(this).load(handCards[1]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) findViewById(R.id.tableCard);
        Picasso.with(this).load(tableCards[0]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) findViewById(R.id.tableCard2);
        Picasso.with(this).load(tableCards[1]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) findViewById(R.id.tableCard3);
        Picasso.with(this).load(tableCards[2]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) findViewById(R.id.tableCard4);
        Picasso.with(this).load(tableCards[3]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) findViewById(R.id.tableCard5);
        Picasso.with(this).load(tableCards[4]).resize(App.targetWidth, App.targetHeight).into(card);

        // stats


        ResultListAdapter resultAdapter = new ResultListAdapter(ResultListActivity.this, handTypeList, selectedPairs);

        resultList = (ListView)findViewById(R.id.resultList);
        resultList.setAdapter(resultAdapter);
    }

}
