package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Play {
    public ArrayList<CardInterface> playCards = new ArrayList<>();

    public void putTo(CardInterface playCard) {
        playCards.add(playCard);
    }

    public int getPoints() {
        int points = 0;
        for (CardInterface card : playCards) {
            points += card.cardType().getPoints();
        }
        return points;
    }

    public ArrayList<CardInterface> throwToDiscardPile() {
        ArrayList<CardInterface> backToDiscardPileCards = new ArrayList<>(playCards);
        playCards.clear();
        return backToDiscardPileCards;
    }
}