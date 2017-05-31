package com.example.ukasz.chance2win;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz on 19.03.2017.
 */

public class Deck {

    private Cards cards[] = new Cards[] {
            Cards.ACE_HEARTS,
            Cards.KING_HEARTS,
            Cards.QUEEN_HEARTS,
            Cards.JACK_HEARTS,
            Cards.C10_HEARTS,
            Cards.C9_HEARTS,
            Cards.C8_HEARTS,
            Cards.C7_HEARTS,
            Cards.C6_HEARTS,
            Cards.C5_HEARTS,
            Cards.C4_HEARTS,
            Cards.C3_HEARTS,
            Cards.C2_HEARTS,

            Cards.ACE_CLUBS,
            Cards.KING_CLUBS,
            Cards.QUEEN_CLUBS,
            Cards.JACK_CLUBS,
            Cards.C10_CLUBS,
            Cards.C9_CLUBS,
            Cards.C8_CLUBS,
            Cards.C7_CLUBS,
            Cards.C6_CLUBS,
            Cards.C5_CLUBS,
            Cards.C4_CLUBS,
            Cards.C3_CLUBS,
            Cards.C2_CLUBS,

            Cards.ACE_DIAMONDS,
            Cards.KING_DIAMONDS,
            Cards.QUEEN_DIAMONDS,
            Cards.JACK_DIAMONDS,
            Cards.C10_DIAMONDS,
            Cards.C9_DIAMONDS,
            Cards.C8_DIAMONDS,
            Cards.C7_DIAMONDS,
            Cards.C6_DIAMONDS,
            Cards.C5_DIAMONDS,
            Cards.C4_DIAMONDS,
            Cards.C3_DIAMONDS,
            Cards.C2_DIAMONDS,

            Cards.ACE_SPADES,
            Cards.KING_SPADES,
            Cards.QUEEN_SPADES,
            Cards.JACK_SPADES,
            Cards.C10_SPADES,
            Cards.C9_SPADES,
            Cards.C8_SPADES,
            Cards.C7_SPADES,
            Cards.C6_SPADES,
            Cards.C5_SPADES,
            Cards.C4_SPADES,
            Cards.C3_SPADES,
            Cards.C2_SPADES,

    };

    public List<Cards> deckList;

    Deck() {
        deckList = new ArrayList<Cards>();
        for(int i = 0; i < cards.length; i++) {
            deckList.add(cards[i]);
        }
    }

    Deck(int resourcesId[]) {
        deckList = new ArrayList<Cards>();
        for(int i = 0; i < cards.length; i++) {
            boolean withoutThisCard = false;
            for(int l = 0; l < resourcesId.length; l++) {
                if(cards[i] == getCardByDrawable(resourcesId[l])) {
                    withoutThisCard = true;
                    break;
                }
            }
            if(!withoutThisCard) {
                deckList.add(cards[i]);
            }

        }
    }

    public void deleteFromDeck(int resourceId) {
        for(int i = 0; i < deckList.size(); i++) {
            Cards currentItem = deckList.get(i);
            if(currentItem.getDrawable() == resourceId) {
                deckList.remove(i);
                break;
            }
        }
    }

    public void addToDeck(Cards card) {
        List<Cards> newDeckList = new ArrayList<Cards>();
        boolean added = false;
        for(int i = 0; i < deckList.size(); i++) {
            Cards currentItem = deckList.get(i);
            if(currentItem.getcardId() < card.getcardId() || added) {
                newDeckList.add(currentItem);
            } else {
                added = true;
                newDeckList.add(card);
                newDeckList.add(currentItem);
            }
        }

        deckList = newDeckList;
    }

    public Cards getCardByDrawable(int resourceId) {
        for(int i = 0; i < cards.length; i++) {
            Cards currentItem = cards[i];
            if(currentItem.getDrawable() == resourceId) {
                return currentItem;
            }
        }
        return null;
    }

    public Integer[] getCardNamesId() {
        Integer[] cardNames = new Integer[deckList.size()];
        for(int i = 0; i < deckList.size(); i++) {
            Cards card = deckList.get(i);
            cardNames[i] = card.getName();
        }

        return cardNames;
    }

    public Integer[] getCardImagesId() {
        Integer[] cardImages = new Integer[deckList.size()];
        for(int i = 0; i < deckList.size(); i++) {
            Cards card = deckList.get(i);
            cardImages[i] = card.getDrawable();
        }

        return cardImages;
    }

    public enum Cards {
        ACE_HEARTS(0, Color.HEARTS, Rank.ACE, R.drawable.ace_of_hearts, R.string.aceOfHearts),
        KING_HEARTS(1, Color.HEARTS, Rank.KING, R.drawable.king_of_hearts2, R.string.kingOfHearts),
        QUEEN_HEARTS(2, Color.HEARTS, Rank.QUEEN, R.drawable.queen_of_hearts2, R.string.queenOfHearts),
        JACK_HEARTS(3, Color.HEARTS, Rank.JACK, R.drawable.jack_of_hearts2, R.string.jackOfHearts),
        C10_HEARTS(4, Color.HEARTS, Rank.C10, R.drawable.c10_of_hearts, R.string.c10OfHearts),
        C9_HEARTS(5, Color.HEARTS, Rank.C9, R.drawable.c9_of_hearts, R.string.c9OfHearts),
        C8_HEARTS(6, Color.HEARTS, Rank.C8, R.drawable.c8_of_hearts, R.string.c8OfHearts),
        C7_HEARTS(7, Color.HEARTS, Rank.C7, R.drawable.c7_of_hearts, R.string.c7OfHearts),
        C6_HEARTS(8, Color.HEARTS, Rank.C6, R.drawable.c6_of_hearts, R.string.c6OfHearts),
        C5_HEARTS(9, Color.HEARTS, Rank.C5, R.drawable.c5_of_hearts, R.string.c5OfHearts),
        C4_HEARTS(10, Color.HEARTS, Rank.C4, R.drawable.c4_of_hearts, R.string.c4OfHearts),
        C3_HEARTS(11, Color.HEARTS, Rank.C3, R.drawable.c3_of_hearts, R.string.c3OfHearts),
        C2_HEARTS(12, Color.HEARTS, Rank.C2, R.drawable.c2_of_hearts, R.string.c2OfHearts),

        ACE_CLUBS(13, Color.CLUBS, Rank.ACE, R.drawable.ace_of_clubs, R.string.aceOfClubs),
        KING_CLUBS(14, Color.CLUBS, Rank.KING, R.drawable.king_of_clubs2, R.string.kingOfClubs),
        QUEEN_CLUBS(15, Color.CLUBS, Rank.QUEEN, R.drawable.queen_of_clubs2, R.string.queenOfClubs),
        JACK_CLUBS(16, Color.CLUBS, Rank.JACK, R.drawable.jack_of_clubs2, R.string.jackOfClubs),
        C10_CLUBS(17, Color.CLUBS, Rank.C10, R.drawable.c10_of_clubs, R.string.c10OfClubs),
        C9_CLUBS(18, Color.CLUBS, Rank.C9, R.drawable.c9_of_clubs, R.string.c9OfClubs),
        C8_CLUBS(19, Color.CLUBS, Rank.C8, R.drawable.c8_of_clubs, R.string.c8OfClubs),
        C7_CLUBS(20, Color.CLUBS, Rank.C7, R.drawable.c7_of_clubs, R.string.c7OfClubs),
        C6_CLUBS(21, Color.CLUBS, Rank.C6, R.drawable.c6_of_clubs, R.string.c6OfClubs),
        C5_CLUBS(22, Color.CLUBS, Rank.C5, R.drawable.c5_of_clubs, R.string.c5OfClubs),
        C4_CLUBS(23, Color.CLUBS, Rank.C4, R.drawable.c4_of_clubs, R.string.c4OfClubs),
        C3_CLUBS(24, Color.CLUBS, Rank.C3, R.drawable.c3_of_clubs, R.string.c3OfClubs),
        C2_CLUBS(25, Color.CLUBS, Rank.C2, R.drawable.c2_of_clubs, R.string.c2OfClubs),

        ACE_DIAMONDS(26, Color.DIAMONDS, Rank.ACE, R.drawable.ace_of_diamonds, R.string.aceOfDiamonds),
        KING_DIAMONDS(27, Color.DIAMONDS, Rank.KING, R.drawable.king_of_diamonds2, R.string.kingOfDiamonds),
        QUEEN_DIAMONDS(28, Color.DIAMONDS, Rank.QUEEN, R.drawable.queen_of_diamonds2, R.string.queenOfDiamonds),
        JACK_DIAMONDS(29, Color.DIAMONDS, Rank.JACK, R.drawable.jack_of_diamonds2, R.string.jackOfDiamonds),
        C10_DIAMONDS(30, Color.DIAMONDS, Rank.C10, R.drawable.c10_of_diamonds, R.string.c10OfDiamonds),
        C9_DIAMONDS(31, Color.DIAMONDS, Rank.C9, R.drawable.c9_of_diamonds, R.string.c9OfDiamonds),
        C8_DIAMONDS(32, Color.DIAMONDS, Rank.C8, R.drawable.c8_of_diamonds, R.string.c8OfDiamonds),
        C7_DIAMONDS(33, Color.DIAMONDS, Rank.C7, R.drawable.c7_of_diamonds, R.string.c7OfDiamonds),
        C6_DIAMONDS(34, Color.DIAMONDS, Rank.C6, R.drawable.c6_of_diamonds, R.string.c6OfDiamonds),
        C5_DIAMONDS(35, Color.DIAMONDS, Rank.C5, R.drawable.c5_of_diamonds, R.string.c5OfDiamonds),
        C4_DIAMONDS(36, Color.DIAMONDS, Rank.C4, R.drawable.c4_of_diamonds, R.string.c4OfDiamonds),
        C3_DIAMONDS(37, Color.DIAMONDS, Rank.C3, R.drawable.c3_of_diamonds, R.string.c3OfDiamonds),
        C2_DIAMONDS(38, Color.DIAMONDS, Rank.C2, R.drawable.c2_of_diamonds, R.string.c2OfDiamonds),

        ACE_SPADES(39, Color.SPADES, Rank.ACE, R.drawable.ace_of_spades, R.string.aceOfSpades),
        KING_SPADES(40, Color.SPADES, Rank.KING, R.drawable.king_of_spades2, R.string.kingOfSpades),
        QUEEN_SPADES(41, Color.SPADES, Rank.QUEEN, R.drawable.queen_of_spades2, R.string.queenOfSpades),
        JACK_SPADES(42, Color.SPADES, Rank.JACK, R.drawable.jack_of_spades2, R.string.jackOfSpades),
        C10_SPADES(43, Color.SPADES, Rank.C10, R.drawable.c10_of_spades, R.string.c10OfSpades),
        C9_SPADES(44, Color.SPADES, Rank.C9, R.drawable.c9_of_spades, R.string.c9OfSpades),
        C8_SPADES(45, Color.SPADES, Rank.C8, R.drawable.c8_of_spades, R.string.c8OfSpades),
        C7_SPADES(46, Color.SPADES, Rank.C7, R.drawable.c7_of_spades, R.string.c7OfSpades),
        C6_SPADES(47, Color.SPADES, Rank.C6, R.drawable.c6_of_spades, R.string.c6OfSpades),
        C5_SPADES(48, Color.SPADES, Rank.C5, R.drawable.c5_of_spades, R.string.c5OfSpades),
        C4_SPADES(49, Color.SPADES, Rank.C4, R.drawable.c4_of_spades, R.string.c4OfSpades),
        C3_SPADES(50, Color.SPADES, Rank.C3, R.drawable.c3_of_spades, R.string.c3OfSpades),
        C2_SPADES(51, Color.SPADES, Rank.C2, R.drawable.c2_of_spades, R.string.c2OfSpades);

        Cards(int cardId, Color color, Rank rank, int drawableId, int cardNameId) {
            this.color = color;
            this.rank = rank;
            this.drawableId = drawableId;
            this.cardNameId = cardNameId;
            this.cardId = cardId;
        }

        private int cardId;

        public int getcardId() {

            return cardId;
        }

        private int drawableId;

        public int getDrawable() {

            return drawableId;
        }

        private int cardNameId;

        public int getName() {

            return cardNameId;
        }

        // Colors
        private Color color;

        public Color getColor() {

            return color;
        }

        public enum Color {
            HEARTS, DIAMONDS, CLUBS, SPADES
        }

        // Ranks
        private Rank rank;

        public Rank getRank() {

            return rank;
        }

        public enum Rank {
            ACE(13), KING(12), QUEEN(11), JACK(10), C10(9), C9(8), C8(7), C7(6), C6(5), C5(4), C4(3), C3(2), C2(1);
            private final int value;

            Rank(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }
        }


    }
}
