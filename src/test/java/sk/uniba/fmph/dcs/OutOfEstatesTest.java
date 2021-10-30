package sk.uniba.fmph.dcs;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OutOfEstatesTest {
    private OutOfEstates outOfEstates1;
    private OutOfEstates outOfEstates2;
    private ArrayList<BuyDeck> buyDecks1;
    private ArrayList<BuyDeck> buyDecks2;

    void setUp() {
        buyDecks1 = new ArrayList<>();
        buyDecks1.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_MARKET));
        buyDecks1.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_VILLAGE));
        buyDecks1.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_MARKET));
        outOfEstates1 = new OutOfEstates(buyDecks1);
        buyDecks2 = new ArrayList<>();
        buyDecks2.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_ESTATE));
        buyDecks2.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_VILLAGE));
        buyDecks2.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_MARKET));
        outOfEstates2 = new OutOfEstates(buyDecks2);
    }

    @Test
    public void test_is_game_over() {
        setUp();
        assertFalse(outOfEstates1.isGameOver());
        assertTrue(outOfEstates2.isGameOver());
    }
}