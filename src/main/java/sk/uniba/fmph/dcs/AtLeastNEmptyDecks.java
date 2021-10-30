package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class AtLeastNEmptyDecks implements EndGameStrategy{

    private final ArrayList<BuyDeck> buyDecks;

    public AtLeastNEmptyDecks(ArrayList<BuyDeck> buyDecks) {
        this.buyDecks = buyDecks;
    }

    @Override
    public boolean isGameOver() {
        int counter = 0;
        for(BuyDeck buyDeck: buyDecks) {
            if (buyDeck.cardCount == 0) {
                counter++;
            }
        }
        return counter >= 3;
    }
}
