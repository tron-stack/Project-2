package com.revature.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardList;

    public Deck(){
        cardList = new ArrayList<>();
        for (Card.Suit mySuit : Card.Suit.values()){
            for (Card.Value myValue : Card.Value.values()){
                cardList.add(new Card(mySuit, myValue);
            }
        }
        Collections.shuffle(cardList);
    }
}
