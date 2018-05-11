package blackjack;

public class Card {
	private Suit suit;
	private Rank rank;

	public String getSuit() {
		return this.suit.toString();
	}

	// public void setSuit(String suit) {
	// this.suit = suit;
	// }

	public String getRank() {
		return this.rank.toString();
	}

	// public void setRank(String rank) {
	// this.rank = rank;
	// }

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;

	}

	public int getValue() {
		switch (rank.toString()) {
		case "ACE": {
			return 11;
		}
		case "KING": {
			return 10;
		}
		case "QUEEN": {
			return 10;
		}
		case "JACK": {
			return 10;
		}
		case "TEN": {
			return 10;
		}
		case "NINE": {
			return 9;
		}
		case "EIGHT": {
			return 8;
		}
		case "SEVEN": {
			return 7;
		}
		case "SIX": {
			return 6;
		}
		case "FIVE": {
			return 5;
		}
		case "FOUR": {
			return 5;
		}
		case "THREE": {
			return 3;
		}
		case "TWO": {
			return 2;
		}
		default: {
			return 0;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}

}
