package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Play {

    private ArrayList<CardInterface> playCards = new ArrayList<>();

    public void putTo(CardInterface playCard) {
        playCards.add(playCard);
    }

    public ArrayList<CardInterface> throwToDiscardPile() {
        ArrayList<CardInterface> backToDiscardPileCards = new ArrayList<>(playCards);
        playCards.clear();
        return backToDiscardPileCards;
    }
}