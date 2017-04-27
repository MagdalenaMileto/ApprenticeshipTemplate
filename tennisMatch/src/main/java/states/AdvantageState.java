package states;

import scoreboard.score.Pair;
import scoreboard.score.Point;

public class AdvantageState extends FortyState {

    public Pair pointsAgainst(GameStateMachine otherState) {
            return new Pair<GameStateMachine, GameStateMachine>(new PlayingState(), new PlayingState());
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
