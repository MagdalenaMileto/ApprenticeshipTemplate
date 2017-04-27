package states;

import scoreboard.score.Pair;

public class DeuceState implements GameState {

    public Pair<GameState, GameState> pointsAgainst(GameState otherState) {
        if(otherState.advantage()){
            return new Pair<GameState, GameState>(this, new DeuceState());
        }
        return new Pair<GameState, GameState>(new AdvantageState(), otherState);
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
