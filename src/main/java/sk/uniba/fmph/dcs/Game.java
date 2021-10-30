package sk.uniba.fmph.dcs;

public class Game {
    private final Turn turn = new Turn();
    private final EndGameStrategy atLeastNEmptyDecks = new AtLeastNEmptyDecks(turn.buyDecks);
    private final EndGameStrategy outOfEstates = new OutOfEstates(turn.buyDecks);
    private boolean gameOver = false;

    public boolean playCard(int handIdx) {
        if (turn.isActionPhase && !gameOver) {
            return turn.playCard(handIdx);
        }
        return false;
    }

    public boolean endPlayCardPhase() {
        if (turn.isActionPhase && !gameOver) {
            turn.isActionPhase = false;
            return true;
        }
        return false;
    }

    public boolean buyCard(int buyDeckIdx) {
        if (!turn.isActionPhase && !gameOver) {
            return turn.buyCard(buyDeckIdx);
        }
        return false;
    }

    public boolean endTurn() {
        if (!turn.isActionPhase) {
            turn.throwToDiscardPile();
            turn.isActionPhase = true;
            if (atLeastNEmptyDecks.isGameOver() || outOfEstates.isGameOver()) {
                int points = turn.pointsCount();
                System.out.println("Toto je koniec hry. Ziskal si: " + points + " bodov.");
                gameOver = true;
            }
            return true;
        }
        return false;
    }
}