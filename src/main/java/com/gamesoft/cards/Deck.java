package com.gamesoft.cards;

/**
 * Represents common functions on a deck of cards. Default implementation is
 * unsupported operations. It is left to the implementation to fill in details.
 */
public interface Deck {
	/**
	 * Shuffle the deck of cards in random order.
	 */
	default void shuffle() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Deals the next card in the set of cards. Once all cards ({@link #size()})
	 * have been dealt, null values will be returned to signify no more cards
	 * available in deck.
	 * 
	 * 
	 * @return next card from the deck
	 */
	default Card dealOneCard() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Returns an array of card in the deck. Whether the array is a deep copy or
	 * shallow copy is left to the implementation.
	 * 
	 * @return array of cards in the deck
	 */
	default Card[] getCards() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Returns the number of cards in the deck.
	 * 
	 * @return number of cards in the deck
	 */
	default int size() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Prints information about each card in the deck. For example the suite type
	 * and card value.
	 * 
	 * @return prints each card in the deck
	 */
	public default String printDeckInfo() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}