package states;

import scoreboard.Pair;

public class Advantage implements GameState {
    public Pair<GameState, GameState> pointAgainst(GameState otherState) {
        return new Pair<GameState, GameState>(new Playing(), new Playing());
    }

    public Boolean forty() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == Advantage.class;
    }
}
