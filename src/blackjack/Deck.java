package blackjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> deck = new ArrayList<>();
	Suit[] suits = Suit.values();
	Rank[] rank = Rank.values();

	public Deck() {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				deck.add(new Card(suits[i], rank[j]));
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
