package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Hand {

    public ArrayList<CardInterface> handCards;
    private Deck deck;

    public Hand(Deck deck) {
        this.deck = deck;
        handCards = new ArrayList<>(deck.draw(5));
    }

    public boolean isActionCard(int idx) {
        return getCardFromHand(idx) != null && getCardFromHand(idx).cardType().isAction();
    }

    public boolean play(int idx) {
        if (isActionCard(idx) && getCardFromHand(idx) != null) {
            handCards.remove(getCardFromHand(idx));
            return true;
        }
        return false;
    }

    public CardInterface getCardFromHand(int idx) {
        if (idx >= handCards.size()) {
            return null;
        }
        return handCards.get(idx);
    }

    public ArrayList<CardInterface> throwToDiscardPile() {
        ArrayList<CardInterface> backToDiscardPileCards = new ArrayList<>(handCards);
        handCards.clear();
        return backToDiscardPileCards;
    }
}