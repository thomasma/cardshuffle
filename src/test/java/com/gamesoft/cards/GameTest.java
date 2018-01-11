package com.gamesoft.cards;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamesoft.cards.Card;
import com.gamesoft.cards.StandardDeck;

/**
 * Unit test the Deck of cards functionality.
 */
public class GameTest {
	private final static Logger logger = LoggerFactory.getLogger(GameTest.class);

	/**
	 * testInitializeNewDeck
	 */
	@Test
	public void testInitializeNewDeck() {
		Deck deck = new StandardDeck();
		assertThat(deck.size()).isEqualTo(52);

		logger.info("=====>>>> Initial new deck order...");
		logger.info(deck.toString());
	}

	/**
	 * testThatTwoNewDecksHaveSameOrder
	 */
	@Test
	public void testThatTwoNewDecksHaveSameOrder() {
		Deck deck1 = new StandardDeck();
		Deck deck2 = new StandardDeck();
		assertThat(Arrays.asList(deck1.getCards())).isEqualTo(Arrays.asList(deck2.getCards()));
	}

	/**
	 * testShuffleDeck
	 */
	@Test
	public void testShuffleDeck() {
		Deck deck1 = new StandardDeck();
		assertThat(deck1.size()).isEqualTo(52);

		Deck deck2 = new StandardDeck();
		assertThat(Arrays.asList(deck1.getCards())).isEqualTo(Arrays.asList(deck2.getCards()));
		deck2.shuffle();
		assertThat(deck2.size()).isEqualTo(52);
		assertThat(Arrays.asList(deck1.getCards())).isNotEqualTo(Arrays.asList(deck2.getCards()));

		logger.info("=====>>>> Shuffled new deck order...");
		logger.info(deck2.toString());
	}

	/**
	 * dealOneCard
	 */
	@Test
	public void testDealOneCard() {
		Deck deck = new StandardDeck();
		deck.shuffle();

		logger.info("=====>>>> Deal one card at a time...");
		IntStream.rangeClosed(0, 52).forEachOrdered(n -> {
			Card card = deck.dealOneCard();
			logger.info("#{} {}", n, card);
			if (n < 52) {
				assertThat(card).isNotNull();
			} else {
				assertThat(card).isNull();
			}
		});
	}

}
