package sk.uniba.fmph.dcs;

public class GameCard implements CardInterface {
    private final GameCardType cardType;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameCard other = (GameCard) obj;
        if (cardType.getCost() != other.cardType.getCost())
            return false;
        if (cardType.getDescription() == null) {
            if (other.cardType.getDescription() != null)
                return false;
        } else if (!cardType.getDescription().equals(other.cardType.getDescription()))
            return false;
        if (cardType.getName() == null) {
            return other.cardType.getName() == null;
        } else return cardType.getName().equals(other.cardType.getName());
    }
}