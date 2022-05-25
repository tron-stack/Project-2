package com.revature.models;


public class Card {

    public enum Suit{
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;

        public static Suit getSuits(int index){
            Suit[] suits = Suit.values();
            return suits[index];
        }
        public static int getSuitLength(){
            return Suit.values().length;
        }
    }

    public enum Value{
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;

        public static Value getValues(int index){
            Value[] values = Value.values();
            return values[index];
        }
        public static int getValueLength(){
            return Value.values().length;
        }
    }

    private Suit suit;

    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
