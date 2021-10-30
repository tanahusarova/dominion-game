package sk.uniba.fmph.dcs;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {
    private Hand hand;

    void setUp() {
        DiscardPile discardPile = new DiscardPile(new ArrayList<>());
        Deck deck = new Deck(new ArrayList<>() {{
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_VILLAGE));
        }}, discardPile);
        hand = new Hand(deck);
    }

    @Test
    public void test_is_action_card() {
        setUp();
        assertTrue(hand.isActionCard(0));
        assertFalse(hand.isActionCard(1));
        assertTrue(hand.isActionCard(2));
        assertFalse(hand.isActionCard(3));
        assertFalse(hand.isActionCard(4));
    }

    @Test
    public void test_is_treasure_card() {
        setUp();
        assertFalse(hand.isTreasureCard(0));
        assertFalse(hand.isTreasureCard(1));
        assertFalse(hand.isTreasureCard(2));
        assertTrue(hand.isTreasureCard(3));
        assertFalse(hand.isTreasureCard(4));
    }

    @Test
    public void test_get_card_from_hand() {
        setUp();
        assertEquals(hand.getCardFromHand(0), new FakeCard(GameCardType.GAME_CARD_TYPE_VILLAGE));
        assertEquals(hand.getCardFromHand(1), new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        assertEquals(hand.getCardFromHand(2), new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
        assertEquals(hand.getCardFromHand(3), new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
        assertEquals(hand.getCardFromHand(4), new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
    }

    @Test
    public void test_throw_to_discard_pile() {
        setUp();
        assertEquals(hand.throwToDiscardPile(), new ArrayList<>() {{
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_VILLAGE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        }});
    }

    @Test
    public void test_play() {
        setUp();
        assertFalse(hand.play(10));
        assertFalse(hand.play(4));
        assertTrue(hand.play(3));
        assertTrue(hand.play(2));
        assertFalse(hand.play(1));
        assertTrue(hand.play(0));
    }

    @Test
    public void test_get_points() {
        setUp();
        assertEquals(2, hand.getPoints());
    }
}
