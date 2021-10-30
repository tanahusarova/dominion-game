package sk.uniba.fmph.dcs;

public class BuyDeck {
    public int cardCount;
    public GameCardType deckTypeCard;

    public BuyDeck(int cardCount, GameCardType deckTypeCard) {
        this.cardCount = cardCount;
        this.deckTypeCard = deckTypeCard;
    }

    public void buy() {
        cardCount--;
    }

    public int getCardCount(){
        return cardCount;
    }

    public CardInterface getCardFromBuyDeck() {
        return new GameCard(deckTypeCard);
    }
}