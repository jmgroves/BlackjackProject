package com.skilldistillery.enums.drills.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.enums.solutions.cards.Card;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	Suit[] suits = Suit.values();
	Rank[] rank = Rank.values();

	public Deck() {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				deck.add(new Card(suits[i].toString(), rank[j].toString()));
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}
	public void shuffle() {
		 Collections.shuffle(deck);
	}
}
