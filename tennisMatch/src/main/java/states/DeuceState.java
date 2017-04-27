package states;

import scoreboard.score.Pair;

public class DeuceState implements GameStateMachine {

    public Pair<GameStateMachine, GameStateMachine> pointsAgainst(GameStateMachine otherState) {
        if(otherState.advantage()){
            return new Pair<GameStateMachine, GameStateMachine>(this, new DeuceState());
        }
        return new Pair<GameStateMachine, GameStateMachine>(new AdvantageState(), otherState);
    }

    public Boolean forty() {
        return true;
    }
    public Boolean advantage() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == DeuceState.class;
    }
}
