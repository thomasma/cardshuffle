package com.gamesoft.cards;

/**
 * Represents a single card in a deck of cards. A card is defined by its
 * {@link CardValue} and {@link SuitType}.
 */
public class Card {

	/** Card suit type enum */
	public enum SuitType {
		HEARTS, SPADES, CLUBS, DIAMONDS;
	}

	/** Card value enum. */
	public enum CardValue {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(
				12), KING(13);
		private int cardValue;

		CardValue(int cardValue) {
			this.cardValue = cardValue;
		}

		public int getCardValue() {
			return this.cardValue;
		}
	}

	/** Card suit type */
	private SuitType suitType;

	/** Card value enum. */
	private CardValue cardValue;

	/**
	 * Initialize a new card.
	 * 
	 * @param suitType
	 * @param cardValue
	 */
	public Card(Card.SuitType suitType, Card.CardValue cardValue) {
		this.suitType = suitType;
		this.cardValue = cardValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardValue == null) ? 0 : cardValue.hashCode());
		result = prime * result + ((suitType == null) ? 0 : suitType.hashCode());
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
		if (cardValue != other.cardValue)
			return false;
		if (suitType != other.suitType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [suitType=" + suitType + ", cardValue=" + cardValue + "]";
	}
}
