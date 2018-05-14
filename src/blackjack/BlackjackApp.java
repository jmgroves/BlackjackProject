package blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);
	Deck deck = new Deck();
	BlackjackHand playerHand = new BlackjackHand();
	BlackjackHand dealerHand = new BlackjackHand();
	private int playerWallet = 1500;
	private int bet;

	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();

		bj.run();
	}

	private void run() {
		System.out.println("Welcome to the Blackjack Table!");
		dealGame();

	}

	private void dealGame() {
		playerBet();
		playerHand.clearHand();
		dealerHand.clearHand();
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println("Shuffling...");
		pause();
		System.out.println("Dealing...");
		pause();
		playerHand.addCard(deck.dealCard());
		pause();
		System.out.println("Player - " + playerHand.hand.toString());
		dealerHand.addCard(deck.dealCard());
		pause();
		System.out.println("Dealer - " + dealerHand.hand.toString());
		playerHand.addCard(deck.dealCard());
		pause();
		System.out.println("Player - " + playerHand.hand.toString());
		dealerHand.addCard(deck.dealCard());
		pause();
		System.out.println("Dealer - [" + dealerHand.hand.get(0) + ", *FACEDOWN*]");
		System.out.println("\n\nDealer shows a " + dealerHand.hand.get(0));
		checkForBlackjacks();
		System.out.println("What would you like to to?");
		playerAction();

	}

	private void playerBet() {
		boolean badBet = true;
		System.out.println("You have $" + playerWallet + ".\n" + "How much would you like to bet?");
		bet = kb.nextInt();
		if (bet > playerWallet || bet < 0) {
			while (badBet) {
				System.out.println("Invalid bet. Please try again.");
				bet = kb.nextInt();
				if (bet <= playerWallet && bet > 0) {
					badBet = false;
					break;
				}
			}
		}

	}

	private void pause() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void checkForBlackjacks() {
		if (playerHand.getHandValue() == 21 && playerHand.getHandValue() == dealerHand.getHandValue()) {
			System.out.println("Pushing on blackjacks, yikes.");
			push();
		}
		if (playerHand.getHandValue() == 21) {
			System.out.println("Blackjack!!");
			playerWallet += (bet * .5);
			win();
		}
		if (dealerHand.getHandValue() == 21) {
			System.out.println(dealerHand.hand.toString());
			System.out.println("Dealer has Blackjack. YOU LOSE");
			lose();
		}
	}

	private void lose() {
		System.out.println("Sorry bud. You lose.");
		playerWallet -= bet;
		if (playerWallet <= 0) {
			System.out.println("Sorry! You've lost all your money.\nGAME OVER");
			System.exit(0);
		}
		playAgain();

	}

	private void playAgain() {
		System.out.println("Play again? [Y/N]");
		kb.nextLine();
		String choice = kb.nextLine();
		switch (choice.toUpperCase()) {
		case "Y":
			dealGame();
		case "N":
			end();
		}
	}

	private void end() {
		System.out.println("Goodbye!");
		System.exit(0);
	}

	private void push() {
		System.out.println("You push.");
		playAgain();
	}

	private void win() {
		System.out.println("You win! Conrgats!");
		playerWallet += bet;
		playAgain();
	}

	private void playerAction() {
		boolean bust = false;
		while (!bust) {
			System.out.println("[1] - Hit");
			System.out.println("[2] - Stand");
			int choice = kb.nextInt();

			switch (choice) {
			case 1: {
				playerHand.addCard(deck.dealCard());
				System.out.println("Player - " + playerHand.hand.toString());
				bust = checkHand();
				if (bust == true) {
					break;
				}
				continue;
			}
			case 2:
				dealerAction();
			default: {
				System.out.println("Invalid, try again");
				playerAction();
			}

			}
		}
	}

	private boolean checkHand() {
		if (playerHand.getHandValue() > 21) {
			System.out.println("BUST!");
			lose();
			return true;
		}
		return false;
	}

	private void dealerAction() {
		System.out.println("Dealer - " + dealerHand.hand.toString());
		while (true) {
			if (dealerHand.getHandValue() < 17) {
				dealerHand.addCard(deck.dealCard());
				pause();
				System.out.println("Dealer - " + dealerHand.hand.toString());
				continue;
			}
			if (dealerHand.getHandValue() > 21) {
				System.out.println("Dealer has " + dealerHand.getHandValue());
				System.out.println("Dealer busts!");
				win();
			} else {
				System.out.println("Dealer has " + dealerHand.getHandValue());
				System.out.println("You have " + playerHand.getHandValue());
				if (playerHand.getHandValue() > dealerHand.getHandValue()) {
					win();
				} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
					lose();
				} else {
					push();
				}
			}

		}

	}
}
