package sk.uniba.fmph.dcs;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {
    private Deck deck;
    private DiscardPile discardPile;

    void setUp() {
        discardPile = new DiscardPile(new ArrayList<>() {{
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_SMITHY));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_VILLAGE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_LABORATORY));
        }});
        deck = new Deck(new ArrayList<>() {{
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_SMITHY));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_VILLAGE));
        }}, discardPile);
    }

    @Test
    public void test_draw() {
        setUp();
        assertEquals(5, deck.deckSize());
        assertEquals(deck.draw(1), new ArrayList<>() {{
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_VILLAGE));
        }});
        assertEquals(4, deck.deckSize());
        deck.draw(4);
        assertEquals(0, deck.deckSize());
        deck.draw(3);
        assertNotEquals(4, deck.deckSize());
        assertEquals(3, deck.deckSize());
    }

    @Test
    public void test_get_points(){
        setUp();
        assertEquals(1, deck.getPoints());
    }

    @Test
    public void test_deck_size(){
        setUp();
        assertEquals(5, deck.deckSize());
    }
}
