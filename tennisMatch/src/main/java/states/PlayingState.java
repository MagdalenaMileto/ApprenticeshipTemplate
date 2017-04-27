package states;

import scoreboard.score.Pair;
import scoreboard.score.Point;

public class PlayingState implements GameState {

    Point points;

    public PlayingState(Point startingPoints) {
        points = startingPoints;
    }

    public PlayingState() {
        points = Point.Love;
    }

    public Pair<GameState, GameState> pointsAgainst(GameState otherState) {
        if (this.wasThirty()) {
            if (otherState.forty()) {
                return new Pair<GameState, GameState>(new DeuceState(), new DeuceState());
            } else{
                points = points.next();
                return new Pair<GameState, GameState>(new FortyState(), otherState);
            }
        } else {
            return new Pair<GameState, GameState>(new PlayingState(points.next()), otherState);
        }
    }

    public Boolean forty() {
        return false;
    }
    public Boolean advantage() {
        return false;
    }
    private Boolean wasThirty() {
        return points == Point.Thirty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingState playingState = (PlayingState) o;

        return points == playingState.points;
    }
}
