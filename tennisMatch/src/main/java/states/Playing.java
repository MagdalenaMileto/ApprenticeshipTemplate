package states;

import scoreboard.Pair;
import scoreboard.Point;

public class Playing implements GameState {

    Point points;

    public Playing(Point startingPoints) {
        points = startingPoints;
    }

    public Playing() {
        points = Point.Love;
    }


    public Pair<GameState, GameState> pointAgainst(GameState otherState) {
        if (this.wasThirty()) {
            if (otherState.forty()) {
                return new Pair<GameState, GameState>(new Deuce(), new Deuce());
            } else {
                return new Pair<GameState, GameState>(new Advantage(), otherState);
            }
        } else {
            return new Pair<GameState, GameState>(new Playing(points.next()), otherState);
        }
    }

    public Boolean forty() {
        return false;
    }

    private boolean wasThirty() {
        return points == Point.Thirty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playing playing = (Playing) o;

        return points == playing.points;
    }

    @Override
    public int hashCode() {
        return points.hashCode();
    }
}
