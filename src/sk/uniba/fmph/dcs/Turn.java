package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Turn {

    private TurnStatus turnStatus = new TurnStatus();
    private Hand hand;
    private Deck deck;
    private DiscardPile discardPile;
    private Play play;
    public boolean isActionPhase = true;

    public Turn() {
        this.turnStatus.actions = 1;
        this.turnStatus.buys = 1;
        this.turnStatus.coins = 0;
        ArrayList<CardInterface> baseCards = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            GameCard gameCard = new GameCard(GameCardType.GAME_CARD_TYPE_COPPER);
            baseCards.add(gameCard);
        }
        for (int i = 0; i < 3; i++) {
            GameCard gameCard = new GameCard(GameCardType.GAME_CARD_TYPE_ESTATE);
            baseCards.add(gameCard);
        }
        discardPile = new DiscardPile(new ArrayList<>());
        deck = new Deck(baseCards, discardPile);
        hand = new Hand(deck);
        play = new Play();
    }

    public boolean playCard(int idx) {
        if (turnStatus.actions > 0 && hand.play(idx)) {
            CardInterface card = hand.getCardFromHand(idx);
            play.putTo(card);
            turnStatus.actions--;
            card.evaluate(turnStatus);
            hand.handCards.addAll(deck.draw(card.cardType().getPlusCards()));
            return true;
        }
        return false;
    }

    public void throwToDiscardPile() {
        discardPile.addCards(hand.throwToDiscardPile());
        discardPile.addCards(play.throwToDiscardPile());
    }


}
