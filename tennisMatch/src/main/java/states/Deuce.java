package states;

import scoreboard.Pair;

public class Deuce implements GameState {

    public Pair<GameState, GameState> pointAgainst(GameState otherState) {
        return new Pair<GameState, GameState>(new Advantage(), otherState);
    }

    public Boolean forty() {
        return true;
    }
}
