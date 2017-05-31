package com.example.ukasz.chance2win;

/**
 * Created by Łukasz on 31.05.2017.
 */

public class Probability {
    private int allHands;
    private int checkedHands;
    private int playersCount;

    Probability(int allHands, int checkedHans, int playersCount) {
        this.allHands = allHands;
        this.checkedHands = checkedHans;
        this.playersCount = playersCount;
    }

    public double getProbability() {
        double result = 1.0 * checkedHands/allHands;
        for(int i = 1; i < playersCount; i++) {
            result *= ((double)checkedHands-i)/(allHands-i);
        }
        return result * 100;
    }
}
