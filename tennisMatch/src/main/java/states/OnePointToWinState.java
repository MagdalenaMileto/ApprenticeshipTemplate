package states;

import scoreboard.Pair;

public class OnePointToWinState implements GameState {
    public Pair<GameState, GameState> pointsAgainst(GameState otherState) {
        return new Pair<GameState, GameState>(new PlayingState(), new PlayingState());
    }

    public Boolean forty() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == OnePointToWinState.class;
    }
}
