package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Deck {
    private final ArrayList<CardInterface> deckCards;
    private final DiscardPile discardPile;

    public Deck(ArrayList<CardInterface> cards, DiscardPile discardPile) {
        deckCards = new ArrayList<>(cards);
        this.discardPile = discardPile;
    }

    public ArrayList<CardInterface> draw(int count) {
        ArrayList<CardInterface> cardsToDraw = new ArrayList<>();
        int size = deckCards.size();
        if (size < count) {
            ArrayList<CardInterface> newDeckCards = new ArrayList<>(discardPile.shuffle());
            newDeckCards.addAll(deckCards);
            deckCards.clear();
            deckCards.addAll(newDeckCards);
        }
        size = deckCards.size();
        for (int i = 0; i < count; i++) {
            CardInterface card = deckCards.get(size - 1 - i);
            cardsToDraw.add(card);
            deckCards.remove(size - 1 - i);
        }
        return cardsToDraw;
    }

    public int getPoints() {
        int points = 0;
        for(CardInterface card: deckCards) {
            points += card.cardType().getPoints();
        }
        return points;
    }

    public int deckSize() {
        return deckCards.size();
    }
}