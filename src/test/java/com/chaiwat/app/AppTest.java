package com.chaiwat.app;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.*;
import java.io.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

	/* helper class for method name (Chaiwat)
	*/
	public static String getMethodName()
	{
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

    /**
     * Rigourous Test :-)
     */
    public void testCard()
    {
		Card card1 = new Card(1, Card.SUIT_HEARTS);
		System.out.println("Unit testing " + getMethodName() + "()");
        assertTrue( (card1.getValue() == 1) && (card1.getSuit() == Card.SUIT_HEARTS));
    }

    public void testDeckOfCards()
    {
		System.out.println("Unit testing test case: " + getMethodName() + "()");
		DeckOfCards deck = new DeckOfCards();
		System.out.println(deck);
        assertTrue( deck.getNumberOfCards() == 52);
		for(int i=0; i<52; i++) {
			//System.out.println(deck.getCardByIndex(i).getValue());
			assertTrue(deck.getCardByIndex(i).getValue() == (i%13)+1);
		}
    }

	public void testShuffle()
	{
		System.out.println("Unit testing test case: " + getMethodName() + "()");
		DeckOfCards deck1 = new DeckOfCards();
		DeckOfCards deck2 = new DeckOfCards();
		deck1.shuffle();
		
		for(int i=0; i<52; i++) {
			System.out.println("card[" + i + "] - " + deck1.getCardByIndex(i) + " - " + deck2.getCardByIndex(i));
			assertTrue(!deck1.getCardByIndex(i).equals(deck2.getCardByIndex(i)));
		}
	}

}
