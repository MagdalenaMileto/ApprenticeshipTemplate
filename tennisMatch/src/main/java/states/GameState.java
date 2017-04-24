package states;

import scoreboard.Pair;

public interface GameState {
    Pair<GameState, GameState> pointsAgainst(GameState otherState);

    Boolean forty();
}