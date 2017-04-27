package states;

import scoreboard.score.Pair;

public class FortyState implements GameState {

    public Pair<GameState, GameState> pointsAgainst(GameState otherState) {
        sumOneSetPoint();
        return new Pair<GameState, GameState>(new PlayingState(), new PlayingState());
    }

    public void sumOneSetPoint() {

    }

    public Boolean forty() {
        return true;
    }

    public Boolean advantage() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == FortyState.class;
    }
}
