package com.gamesoft.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a standard deck of 52 cards (as defined in {@link Card.CardValue}
 * for each {@link Card.SuitType}
 */
public class StandardDeck implements Deck {

	private Card[] deckOfCards = new Card[] {};

	private int currentIndex = 0;

	/**
	 * Initialize a new standard deck of cards.
	 */
	public StandardDeck() {
		initializeNewDeck();
	}

	/**
	 * Initialize deck with 52 cards. Reset card reader index to first card on the
	 * deck.
	 */
	private void initializeNewDeck() {
		List<Card> cardsList = new ArrayList<Card>();
		for (Card.SuitType suitType : Card.SuitType.values()) {
			for (Card.CardValue cardValue : Card.CardValue.values()) {
				Card card = new Card(suitType, cardValue);
				cardsList.add(card);
			}
		}

		deckOfCards = cardsList.toArray(new Card[0]);
		currentIndex = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gamesoft.cards.Deck#shuffle()
	 */
	@Override
	public void shuffle() {
		for (int i = deckOfCards.length - 1; i > 0; i--) {
			int randomIndx = (int) (Math.random() * (i + 1));
			Card temp = deckOfCards[i];
			deckOfCards[i] = deckOfCards[randomIndx];
			deckOfCards[randomIndx] = temp;
		}
		currentIndex = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gamesoft.cards.Deck#dealOneCard()
	 */
	@Override
	public Card dealOneCard() {
		if (currentIndex > 51) {
			return null;
		}
		return deckOfCards[currentIndex++];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gamesoft.cards.Deck#getCards()
	 */
	@Override
	public Card[] getCards() {
		return deckOfCards.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gamesoft.cards.Deck#size()
	 */
	@Override
	public int size() {
		return deckOfCards.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gamesoft.cards.Deck#printDeckInfo()
	 */
	@Override
	public String printDeckInfo() {
		return toString();
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		int i = 1;
		for (Card card : deckOfCards) {
			buf.append("\n#").append(i + " ");
			buf.append(card);
			i++;
		}
		return buf.toString();
	}
}
