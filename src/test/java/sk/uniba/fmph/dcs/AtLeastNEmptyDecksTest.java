package sk.uniba.fmph.dcs;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AtLeastNEmptyDecksTest {
    private AtLeastNEmptyDecks atLeastNEmptyDecks1;
    private AtLeastNEmptyDecks atLeastNEmptyDecks2;
    private ArrayList<BuyDeck> buyDecks1;
    private ArrayList<BuyDeck> buyDecks2;

    void setUp() {
        buyDecks1 = new ArrayList<>();
        buyDecks1.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_MARKET));
        buyDecks1.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_VILLAGE));
        buyDecks1.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_MARKET));
        atLeastNEmptyDecks1 = new AtLeastNEmptyDecks(buyDecks1);
        buyDecks2 = new ArrayList<>();
        buyDecks2.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_MARKET));
        buyDecks2.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_VILLAGE));
        buyDecks2.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_MARKET));
        buyDecks2.add(new BuyDeck(0, GameCardType.GAME_CARD_TYPE_FESTIVAL));
        atLeastNEmptyDecks2 = new AtLeastNEmptyDecks(buyDecks2);
    }

    @Test
    public void test_is_game_over() {
        setUp();
        assertFalse(atLeastNEmptyDecks1.isGameOver());
        assertTrue(atLeastNEmptyDecks2.isGameOver());
    }
}