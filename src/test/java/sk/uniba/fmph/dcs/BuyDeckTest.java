package sk.uniba.fmph.dcs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyDeckTest {
    public int cardCount;
    public GameCardType deckTypeCard;
    private BuyDeck buyDeck;

    public void setUp() {
        cardCount = 5;
        deckTypeCard = GameCardType.GAME_CARD_TYPE_MARKET;
        buyDeck = new BuyDeck(cardCount, deckTypeCard);
    }

    @Test
    public void test_get_card_count() {
        setUp();
        assertEquals(5, buyDeck.getCardCount());
    }

    @Test
    public void test_buy() {
        setUp();
        buyDeck.buy();
        assertEquals(4, buyDeck.getCardCount());
    }

    @Test
    public void test_get_card_from_buy_deck() {
        setUp();
        assertEquals(GameCardType.GAME_CARD_TYPE_MARKET, buyDeck.getCardFromBuyDeck().cardType());
    }
}