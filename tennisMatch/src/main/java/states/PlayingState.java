package states;

import scoreboard.Pair;
import scoreboard.Point;

public class PlayingState implements GameStateMachine {

    Point points;

    public PlayingState(Point startingPoints) {
        points = startingPoints;
    }

    public PlayingState() {
        points = Point.Love;
    }

    public Pair<GameStateMachine, GameStateMachine> pointsAgainst(GameStateMachine otherState) {
        if (this.wasThirty()) {
            if (otherState.forty()) {
                return new Pair<GameStateMachine, GameStateMachine>(new DeuceState(), new DeuceState());
            } else {
                return new Pair<GameStateMachine, GameStateMachine>(new FortyState(), otherState);
            }
        } else {
            return new Pair<GameStateMachine, GameStateMachine>(new PlayingState(points.next()), otherState);
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
