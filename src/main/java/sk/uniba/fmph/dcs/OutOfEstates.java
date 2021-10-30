package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.Objects;

public class OutOfEstates implements EndGameStrategy {

    private final ArrayList<BuyDeck> buyDecks;

    public OutOfEstates(ArrayList<BuyDeck> buyDecks) {
        this.buyDecks = buyDecks;
    }

    @Override
    public boolean isGameOver() {
        for (BuyDeck buyDeck : buyDecks) {
            if (Objects.equals(buyDeck.getCardFromBuyDeck().cardType().getName(), "Estate")) {
                return buyDeck.cardCount == 0;
            }
        }
        return false;
    }
}
