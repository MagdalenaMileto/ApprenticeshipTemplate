package states;

import scoreboard.Pair;

public interface GameState {
    Pair<GameState, GameState> pointAgainst(GameState otherState);

    Boolean forty();
}

