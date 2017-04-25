package states;

import scoreboard.Pair;

public interface GameState {
    Pair<GameState, GameState> pointsAgainst(GameState otherState);
    Pair<GameState,GameState> goBackToDeuce(GameState player1State);

    Boolean forty();
    Boolean advantage();
}