package states;

import scoreboard.Pair;

public class Forty implements GameState {
    public Pair<GameState, GameState> pointsAgainst(GameState otherState) {
        return new Pair<GameState, GameState>(new PlayingState(), new PlayingState());
    }

    public Boolean forty() {
        return true;
    }
    public Boolean advantage() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == Forty.class;
    }

    public Pair<GameState, GameState> goBackToDeuce(GameState player1State) {
        return null;
    }
}
