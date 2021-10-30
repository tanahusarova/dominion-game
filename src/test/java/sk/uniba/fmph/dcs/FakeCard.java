package sk.uniba.fmph.dcs;

public class FakeCard implements CardInterface {
    private GameCardType _cardType;

    FakeCard(GameCardType __cardType) {
        _cardType = __cardType;
    }

    public void evaluate(TurnStatus t) {
    }

    public GameCardType cardType() {
        return _cardType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FakeCard other = (FakeCard) obj;
        if (_cardType.getCost() != other._cardType.getCost())
            return false;
        if (_cardType.getDescription() == null) {
            if (other._cardType.getDescription() != null)
                return false;
        } else if (!_cardType.getDescription().equals(other._cardType.getDescription()))
            return false;
        if (_cardType.getName() == null) {
            return other._cardType.getName() == null;
        } else return _cardType.getName().equals(other._cardType.getName());
    }

}
