package com.chaiwat.app;
import java.util.*;

public class DeckOfCards {
	Card[] deck;
	int cards;

	// Constructor to construct a standard deck of cards with 52 cards
	public DeckOfCards() {
		deck = new Card[Card.STD_DECK_SIZE];
		cards = Card.STD_DECK_SIZE;
		System.out.println("deck size = " + deck.length);
		deckInit();
	}

	public int getNumberOfCards() {
		return cards;
	}
	public Card getCardByIndex(int index) {
		return deck[index];
	}

	public void shuffle() {
		Random r = new Random();
		Card temp = null;
		for(int i=0; i<deck.length; i++) {
			int j = r.nextInt(Card.STD_DECK_SIZE);
			temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
			//System.out.println("shuffle i=" + i + ", j=" +j);
		}
	}

	private boolean deckInit() {
		if(deck == null) {
			System.out.println("Failed, deckInit() empty deck!!!");
			return false;
		}
		for(int i=0; i<Card.CARD_VALUE_MAX; i++) {
			deck[i] = new Card(i+1, Card.SUIT_HEARTS);
			//System.out.println("deckInit(i) i=" + deck[i]);
		}
		for(int i=Card.CARD_VALUE_MAX; i<Card.CARD_VALUE_MAX * 2 ; i++) {
			deck[i] = new Card((i%Card.CARD_VALUE_MAX)+1, Card.SUIT_CLUBS);
			//System.out.println("deckInit(i) i=" + deck[i].getValue());
		}
		for(int i=Card.CARD_VALUE_MAX * 2; i<Card.CARD_VALUE_MAX * 3 ; i++) {
			deck[i] = new Card((i%Card.CARD_VALUE_MAX)+1, Card.SUIT_SPADES);
			//System.out.println("deckInit(i) i=" + deck[i].getValue());
		}
		for(int i=Card.CARD_VALUE_MAX * 3; i<deck.length; i++) {
			deck[i] = new Card((i%Card.CARD_VALUE_MAX)+1, Card.SUIT_DIMONDS);
			//System.out.println("deckInit(i) i=" + deck[i].getValue());
		}

		return true;
	}


	@Override 
	public String toString() {
		StringBuffer output = new StringBuffer();
		for(Card c : deck) {
			output.append(c);
		}
		return output.toString();
	}
}

