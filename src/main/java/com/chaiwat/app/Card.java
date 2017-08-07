package com.chaiwat.app;

public class Card {
	public static int CARD_VALUE_MIN = 1;
	public static int CARD_VALUE_MAX = 13;
	public static int STD_DECK_SIZE = 52;
	public static int SUIT_HEARTS = 1;
	public static int SUIT_CLUBS = 2;
	public static int SUIT_SPADES = 3;
	public static int SUIT_DIMONDS = 4;

	public static String HEARTS = "Hearts";
	public static String CLUBS = "Clubs";
	public static String SPADES = "Spades";
	public static String DIMONDS = "Dimonds";

	private int value;
	private int suit;

	public Card(int v, int s) {
		value = v;
		suit = s;
	}

	public int getValue() {
		return value;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public void setValue(int v) {
		value = v;
	}

	public boolean equalsTo(Card b) {
		if((value == b.value) && (suit == b.suit))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		String suitStr = null;
		
		if(suit == SUIT_HEARTS) suitStr = HEARTS;
		if(suit == SUIT_SPADES) suitStr = SPADES;
		if(suit == SUIT_CLUBS) suitStr = CLUBS;
		if(suit == SUIT_DIMONDS) suitStr = DIMONDS;
		
		return "[" + suitStr + ":" + value + "]";
	}
}

