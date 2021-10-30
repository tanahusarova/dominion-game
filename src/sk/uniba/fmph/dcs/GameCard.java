package sk.uniba.fmph.dcs;

public class GameCard implements CardInterface{

    private GameCardType cardType;

    public GameCard(GameCardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public void evaluate(TurnStatus ts) {
        ts.actions += cardType().getPlusActions();
        ts.buys += cardType().getPlusBuys();
        ts.coins += cardType().getPlusCoins();
    }

    @Override
    public GameCardType cardType() {
        return cardType;
    }
}
