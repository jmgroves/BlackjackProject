package com.skilldistillery.enums.drills.cards;

public class Card {
	private Suit suit;
	private Rank rank;

	public String getSuit() {
		return this.suit.toString();
	}

//	public void setSuit(String suit) {
//		this.suit = suit;
//	}

	public String getRank() {
		return this.rank.toString();
	}

//	public void setRank(String rank) {
//		this.rank = rank;
//	}

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;

	}

	public int getValue(Card card) {
		switch (card.rank.toString()) {
		case "Ace": {
			return 14;
		}
		case "King": {
			return 13;
		}
		case "Queen": {
			return 12;
		}
		case "Jack": {
			return 11;
		}
		default: {
			return Integer.parseInt(card.getRank());
		}
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
}
	
}
