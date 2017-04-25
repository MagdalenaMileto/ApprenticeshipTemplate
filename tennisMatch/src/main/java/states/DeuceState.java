package states;

import scoreboard.Pair;

public class DeuceState implements GameState {

    public Pair<GameState, GameState> pointsAgainst(GameState otherState) {
        return new Pair<GameState, GameState>(new OnePointToWinState(), otherState);
    }

    public Boolean forty() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == DeuceState.class;
    }
}
