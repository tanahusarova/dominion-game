package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Deck {

    private ArrayList<CardInterface> deckCards;
    private DiscardPile discardPile;

    public Deck(ArrayList<CardInterface> cards, DiscardPile discardPile) {
        deckCards = new ArrayList<>(cards);
        this.discardPile = discardPile;
    }

    public ArrayList<CardInterface> draw(int count) {
        ArrayList<CardInterface> cardsToDraw = new ArrayList<>();
        if (deckCards.size() < count) {
            discardPile.shuffle();
            ArrayList<CardInterface> newDeckCards = new ArrayList<>(discardPile.cards);
            newDeckCards.addAll(deckCards);
            deckCards.clear();
            deckCards.addAll(newDeckCards);
            discardPile.cards.clear();
        }
        for (int i = 0; i < count; i++) {
            CardInterface card = deckCards.get(deckCards.size() - 1 - i);
            cardsToDraw.add(card);
            deckCards.remove(card);
        }
        return cardsToDraw;
    }

}