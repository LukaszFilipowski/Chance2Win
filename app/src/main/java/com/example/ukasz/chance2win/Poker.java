package com.example.ukasz.chance2win;

import android.util.Log;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Łukasz on 04.04.2017.
 */

public class Poker {

    private static Deck.Cards[] cards;
    private static int handType;
    private static Deck.Cards.Rank card, card2;


    Poker(int[] cards) {
        this.cards = new Deck.Cards[cards.length];
        for(int i=0; i < cards.length; i++) {
            this.cards[i] = App.deck.getCardByDrawable(cards[i]);
        }

        handType = findHandType();

    }

    private Deck.Cards.Rank findStraight() {
        int n = cards.length;
        do {
            for(int i=0; i < n-1; i++) {
                if(cards[i].getRank().getValue() < cards[i+1].getRank().getValue()) {
                    Deck.Cards card = cards[i];
                    cards[i] = cards[i+1];
                    cards[i+1] = card;
                }
            }
            n--;
        } while( n > 1 );

        int maxSeries = 1;
        int currentSeries = 1;
        Deck.Cards.Rank firstElement = null;

        for(int i=0; i < cards.length-1; i++) {
            if(currentSeries < 5) {
                if ((cards[i].getRank().getValue() - 1) == cards[i+1].getRank().getValue()) {
                    if(currentSeries == 1) {
                        firstElement = cards[i].getRank();
                    }
                    currentSeries++;
                    Log.d("DD", cards[i].getRank() + " " + cards[i+1].getRank());
                } else {
                    if (maxSeries < currentSeries) {
                        maxSeries = currentSeries;
                    }
                    currentSeries = 1;
                }
            } else {
                break;
            }
        }

        if(maxSeries < currentSeries) {
            maxSeries = currentSeries;
        }

        if(maxSeries == 5) {
            return firstElement;
        } else {
            return null;
        }
    }

    private int findHandType() {
        int clubs = 0, spades = 0, diamonds = 0, hearts = 0;

        for(int i=0; i < cards.length; i++) {
            switch(cards[i].getColor()) {
                case CLUBS:
                    clubs++;
                    break;
                case SPADES:
                    spades++;
                    break;
                case DIAMONDS:
                    diamonds++;
                    break;
                case HEARTS:
                    hearts++;
                    break;
            }
        }

        boolean flush = false;

        if(clubs >= 5 || spades >= 5 || diamonds >= 5 || hearts >= 5) {

            Deck.Cards.Rank status = findStraight();
            if(findStraight() != null) {
                return 8;
            } else {
                flush = true;
            }

        }

        // 4 of hands
        int max = 0;
        Deck.Cards.Rank currentRank = null;
        for(int i=0; i < cards.length; i++) {

            for(int l=0; l < cards.length; l++) {
                if(i != l) {
                    if (cards[i].getRank() == cards[l].getRank()) {
                        int newMax = howMatch(cards[i].getRank());
                        if(max < newMax) {
                            max = newMax;
                            currentRank = cards[i].getRank();
                        } else {
                            if(max == newMax && currentRank.getValue() < cards[i].getRank().getValue()) {
                                currentRank = cards[i].getRank();
                            }
                        }
                    }
                }
            }

        }

        if(max == 4) {
            card = currentRank;
            return 7;
        } else {
            if(max == 3) {

                for(int i=0; i < cards.length; i++) {
                    for(int l=0; l < cards.length; l++) {
                        if(cards[i].getRank() == cards[l].getRank() && currentRank != cards[i].getRank()) {
                            card = currentRank;
                            return 6;
                        }
                    }
                }

            }

            // flush
            if(flush) {
                return 5;
            }

            // straight
            Deck.Cards.Rank status = findStraight();
            if(status != null) {
                return 4;

            } else {

                // 3 of kind
                if(max == 3) {
                    card = currentRank;
                    return 3;
                }

                // 2 pairs or 1 pair
                if(max == 2) {
                    // 2 pair
                    card = currentRank;
                    for(int i=0; i < cards.length; i++) {
                        for(int l=0; l < cards.length; l++) {
                            if(cards[i].getRank() == cards[l].getRank() && currentRank != cards[i].getRank()) {
                                card2 = currentRank;
                                return 2;
                            }
                        }
                    }
                    // 1 pair
                    return 1;
                }


            }

        }

        // high card
        Deck.Cards.Rank highCard = cards[0].getRank();
        for(int i = 1; i < cards.length; i++) {
            if(cards[i].getRank().getValue() > highCard.getValue()) {
                highCard = cards[i].getRank();
            }
        }
        card = highCard;
        return 0;
    }

    private int howMatch(Deck.Cards.Rank rank) {
        int howMatch = 0;
        for(int i=0; i < cards.length; i++) {
            if(rank == cards[i].getRank()) {
                howMatch++;
            }
        }
        return howMatch;
    }

    public int getHandType() {
        return handType;


    }

}
