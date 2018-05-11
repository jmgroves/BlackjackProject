package com.skilldistillery.enums.drills.cards;

import java.util.Scanner;

public class DeckTester {

	public static void main(String[] args) {
		DeckTester dt = new DeckTester();
		dt.run();
	}

	public void run() {
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println("How many cards do you want?");
		Scanner kb = new Scanner(System.in);
		int choice = kb.nextInt();

		if (choice > 52 || choice < 1) {
			while (true) {
				System.out.println("Please try again, this time with a number of " + "cards I can actually deal.");
				choice = kb.nextInt();
				if (choice < 53 && choice > 0) {
					break;
				}
			}
		}

		for (int i = 0; i < choice; i++) {

			Card card = deck.dealCard();
			System.out.println(card);

		}
	}

}
