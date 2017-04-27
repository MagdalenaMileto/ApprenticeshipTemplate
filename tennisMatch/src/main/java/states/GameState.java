package states;

import scoreboard.score.Pair;

public interface GameState {

    Pair<GameState, GameState> pointsAgainst(GameState otherState);

    Boolean forty();
    Boolean advantage();
}