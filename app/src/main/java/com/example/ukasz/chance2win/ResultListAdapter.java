package com.example.ukasz.chance2win;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Łukasz on 07.04.2017.
 */

public class ResultListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> handName;
    private final LinkedList<Integer[]> handCards;

    public ResultListAdapter(Activity context, List<String> handTypeList, LinkedList<Integer[]> handCards) {
        super(context, R.layout.item_hand_list, handTypeList);
        this.context = context;
        this.handName = handTypeList;
        this.handCards = handCards;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_hand_list, null, true);
        TextView cardName = (TextView) rowView.findViewById(R.id.handName);
        cardName.setText(handName.get(position));

        Integer[] currentCards = handCards.get(position);

        ImageView card = (ImageView) rowView.findViewById(R.id.Card1);
        Picasso.with(context).load(currentCards[0]).resize(App.targetWidth, App.targetHeight).into(card);

        card = (ImageView) rowView.findViewById(R.id.tableCard2);
        Picasso.with(context).load(currentCards[1]).resize(App.targetWidth, App.targetHeight).into(card);

        return rowView;
    }

}
