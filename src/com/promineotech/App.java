package com.promineotech;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            playGame();

            System.out.print("Shall we play again? (Y/N): ");
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("Y")) {
                System.out.println("Have a nice day!");
                scanner.close();
                break;
            }

        } while (true);
    }

    private static void playGame() {
        // Initialize players and deck
        Player player1 = new Player();
        Player player2 = new Player();
        Deck deck = new Deck();

        // Show unshuffled deck
        System.out.println("Unshuffled Deck:");
        deck.showUnshuffledDeck();

        // Shuffle the deck
        deck.shuffle();

        // Deal cards to players
        deck.deal(player1, player2);

        // Show players' hands before the game begins
        System.out.println("\nPlayer 1's Hand: " + player1.getHand());
        System.out.println("Player 2's Hand: " + player2.getHand());

        // Play 26 rounds
        for (int round = 1; round <= 26; round++) {
            System.out.println("\nRound " + round + ":");
            playRound(player1, player2);
            System.out.println("Player 1's Total Points: " + player1.getScore());
            System.out.println("Player 2's Total Points: " + player2.getScore());
        }

        // Determine the winner or declare a tie
        if (player1.getScore() > player2.getScore()) {
            System.out.println("\nPlayer 1 wins the game!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println("\nPlayer 2 wins the game!");
        } else {
            System.out.println("\nThe game ends in a tie!");
        }
    }

    private static void playRound(Player player1, Player player2) {
        Card card1 = player1.getHand().remove(0);
        Card card2 = player2.getHand().remove(0);

        System.out.println("Player 1 plays: " + card1);
        System.out.println("Player 2 plays: " + card2);

        int result = Integer.compare(card1.getRank(), card2.getRank());

        if (result > 0) {
            player1.updateScore(1);
            System.out.println("Player 1 wins, 1 point awarded");
        } else if (result < 0) {
            player2.updateScore(1);
            System.out.println("Player 2 wins, 1 point awarded");
        } else {
            System.out.println("It's a TIE, neither player gets a point");
        }
    }
}
