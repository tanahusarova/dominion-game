package sk.uniba.fmph.dcs;

import java.util.Optional;

interface SimpleDominionInterface {
    Optional<GameState> playCard(int handIdx);

    Optional<GameState> endPlayCardPhase();

    Optional<GameState> buyCard(int buyCardIdx);

    Optional<GameState> endTurn();
}
