package com.example.ukasz.chance2win;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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
          //  Log.d("OOO", Integer.toString(handCards[i]));
            n++;
        }

        for(int i = 0; i < tableCards.length; i++) {
            resourcesId[n] = tableCards[i];
           // Log.d("PPP", Integer.toString(tableCards[i]));
            n++;
        }

        Poker userPoker = new Poker(resourcesId);
        Log.d("GGGGG", userPoker.getHandType());
     //   Log.d("GGGG", Integer.toString(userPoker.compare(userPoker)));

        Deck otherCardsDeck = new Deck(resourcesId);
        Integer[] cards = otherCardsDeck.getCardImagesId();

        for(int i = 0; i < cards.length; i++) {
            Log.d("TTT", Integer.toString(cards[i]));
        }

        List<String> handTypeList = new ArrayList<String>();
        LinkedList<Integer[]> selectedPairs = new LinkedList<Integer[]>();
        int createdObjects = 0;

        for(int i = 0; i < cards.length; i++) {
            for(int l = i; l < cards.length; l++) {
                if (i != l) {


                    int[] selectedPair = new int[7];
                    selectedPair[0] = cards[i];
                    selectedPair[1] = cards[l];

                    for(int o = 2; o < selectedPair.length; o++) {
                        selectedPair[o] = tableCards[o-2];
                    }
                    Poker poker = new Poker(selectedPair);

                    Log.d("2222", poker.getHandType());
                    Log.d("GGGG", Integer.toString(userPoker.compare(poker)));
                    if(userPoker.compare(poker) == 0) {
                        selectedPairs.push(new Integer[]{cards[i], cards[l]});
                        handTypeList.add(poker.getHandType());
                    }

                }
            }
        }

        Log.d("LISTA KART", "GG");
        for(int i=0; i< handTypeList.size(); i++) {
            Log.d("GSASGAG", handTypeList.get(i));
        }

        ResultListAdapter resultAdapter = new ResultListAdapter(ResultListActivity.this, handTypeList, selectedPairs);

        resultList = (ListView)findViewById(R.id.resultList);
        resultList.setAdapter(resultAdapter);
    }

}
