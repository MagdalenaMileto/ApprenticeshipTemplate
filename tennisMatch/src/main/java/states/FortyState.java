package states;

import scoreboard.score.Pair;

public class FortyState implements GameStateMachine {
    public Pair<GameStateMachine, GameStateMachine> pointsAgainst(GameStateMachine otherState) {
        return new Pair<GameStateMachine, GameStateMachine>(new PlayingState(), new PlayingState());
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
