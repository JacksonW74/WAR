package com.promineotech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cards = new ArrayList<>();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void showUnshuffledDeck() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i));
            if (i < cards.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            System.out.println("No cards left in the deck.");
            return null;
        }
    }

    public void deal(Player player1, Player player2) {
        for (int i = 0; i < cards.size(); i += 2) {
            player1.addToHand(cards.get(i));
            player2.addToHand(cards.get(i + 1));
        }
    }
}
