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
 * Created by Łukasz on 20.03.2017.
 */

public class CardListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] cardNames;
    private final Integer[] cardImagesId;

    public CardListAdapter(Activity context, String[] cardNames, Integer[] cardImagesId) {
        super(context, R.layout.item, cardNames);
        this.context = context;
        this.cardNames = cardNames;
        this.cardImagesId = cardImagesId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item, null, true);
        TextView cardName = (TextView) rowView.findViewById(R.id.itemName);
        cardName.setText(cardNames[position]);

        ImageView cardImage = (ImageView) rowView.findViewById(R.id.itemImage);
        Picasso.with(context).load(cardImagesId[position]).resize(100, 120).into(cardImage);

        return rowView;
    }

}
