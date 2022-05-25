package com.revature.services;

import com.revature.models.Card;
import com.revature.models.Deck;

public class DeckService {

    public Deck getNewDeck(){
        Deck newDeck = new Deck();
        return newDeck;
    }
    
    public Card drawCard(Deck drawing){
        Card drawn = drawing.getCardList().get(0);
        drawing.getCardList().remove(0);
        return drawn;
    }
}
