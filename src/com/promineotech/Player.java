package com.promineotech;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int score;

    public Player() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        score += points;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void describe() {
        System.out.println("Player's Hand:");
        for (Card card : hand) {
            card.describe();
        }
    }

    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        } else {
            System.out.println("No cards left in the hand.");
            return null;
        }
    }

    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }
}
