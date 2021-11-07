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
            /* tuto ked napriklad chces tahat 5 kariet ale v baliku mas uz iba 4 (takze podmienka prejde), by si najskor 
            mala vytiahnut tie 4 co boli povodne v decku. Ale pri deckCards.clear ich zahodis, to clear by som dala prec. */
           
            ArrayList<CardInterface> newDeckCards = new ArrayList<>(discardPile.shuffle());
            newDeckCards.addAll(deckCards);
            deckCards.clear(); //len toto
            deckCards.addAll(newDeckCards);
        }
        size = deckCards.size();
        for (int i = 0; i < count; i++) {
            CardInterface card = deckCards.get(size - 1 - i); //si si mohla dat do decku daku pomocnu ze vrat hornu kartu, by si sa potom nemusela trapit s tymto
            cardsToDraw.add(card);
            deckCards.remove(size - 1 - i);
        }
        return cardsToDraw;
    }

    public int getPoints() { //nerobi sa toto az v play triede?
        int points = 0;
        for (CardInterface card : deckCards) {
            points += card.cardType().getPoints();
        }
        return points;
    }

    public int deckSize() {
        return deckCards.size();
    }
}
