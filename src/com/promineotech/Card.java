package com.promineotech;

public class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        switch (rank) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return String.valueOf(rank);
        }
    }

    public void describe() {
        System.out.println("Card: " + getSymbol() + getSuitSymbol());
    }
    
    @Override
    public String toString() {
        return getSymbol() + getSuitSymbol();
    }

    private String getSuitSymbol() {
        switch (suit) {
            case "Hearts":
                return "\u2665";
            case "Diamonds":
                return "\u2666";
            case "Clubs":
                return "\u2663";
            case "Spades":
                return "\u2660";
            default:
                return "";
        }
    }
}
