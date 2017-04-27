package states;

import scoreboard.score.Pair;

public class AdvantageState extends FortyState {

    public Pair pointsAgainst(GameState otherState) {
        sumOneSetPoint();
        return new Pair<GameState, GameState>(new PlayingState(), new PlayingState());
    }

    public Boolean advantage() {
        return true;
    }

    public Boolean forty() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == AdvantageState.class;
    }
}
