package sk.uniba.fmph.dcs;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayTest {
    private Play play;

    void setUp() {
        play = new Play();
    }

    @Test
    public void test_put_to() {
        setUp();
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        assertEquals(play.playCards.get(play.playCards.size() - 1), new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
        assertNotEquals(play.playCards.get(play.playCards.size() - 1), new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
    }

    @Test
    public void test_throw_to_discard_pile() {
        setUp();
        assertEquals(play.throwToDiscardPile(), new ArrayList<>());
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
        assertNotEquals(play.throwToDiscardPile(), new ArrayList<>());
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
        assertEquals(play.throwToDiscardPile(), new ArrayList<>() {{
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_MARKET));
            add(new FakeCard(GameCardType.GAME_CARD_TYPE_COPPER));
        }});
    }

    @Test
    public void test_get_points() {
        setUp();
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        play.putTo(new FakeCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        assertEquals(4, play.getPoints());
    }
}