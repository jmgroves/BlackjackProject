package blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	List<Card> hand;
public Hand() {
	hand = new ArrayList<>();
}
public int getHandValue() {
	int value = 0;
	Card card;
	for(int i = 0; i < hand.size(); i++) {
		card = hand.get(i);
		value += card.getValue();
	}
	return value;
	
}
public void addCard(Card card) {
	hand.add(card);
}
public void clearHand() {
	hand.clear();
		
	
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Your Hand is: ");
	builder.append(hand);
	return builder.toString();
}


}
