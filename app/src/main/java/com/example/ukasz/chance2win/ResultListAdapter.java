package com.example.ukasz.chance2win;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Łukasz on 07.04.2017.
 */

public class ResultListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] handName;
    private final Integer[][] handCards;

    public ResultListAdapter(Activity context, String[] handName, Integer[][] handCards) {
        super(context, R.layout.item_hand_list);
        this.context = context;
        this.handName = handName;
        this.handCards = handCards;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_hand_list, null, true);
        TextView cardName = (TextView) rowView.findViewById(R.id.handName);
        cardName.setText(handName[position]);

        ImageView card = (ImageView) rowView.findViewById(R.id.Card1);
        Picasso.with(context).load(handCards[position][0]).resize(100, 120).into(card);

        card = (ImageView) rowView.findViewById(R.id.Card2);
        Picasso.with(context).load(handCards[position][1]).resize(100, 120).into(card);

        card = (ImageView) rowView.findViewById(R.id.Card3);
        Picasso.with(context).load(handCards[position][2]).resize(100, 120).into(card);

        card = (ImageView) rowView.findViewById(R.id.Card4);
        Picasso.with(context).load(handCards[position][3]).resize(100, 120).into(card);

        card = (ImageView) rowView.findViewById(R.id.Card5);
        Picasso.with(context).load(handCards[position][4]).resize(100, 120).into(card);

        return rowView;
    }

}
