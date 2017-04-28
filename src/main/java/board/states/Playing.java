package board.states;

import board.TennisMatch;
import board.Point;
import board.Score;

import java.util.HashMap;

public class Playing implements GameState {

    HashMap<Integer, Point> scores = new HashMap<>();
    TennisMatch tennisTennisMatch;

    public Playing(TennisMatch tennisMatch) {
        tennisTennisMatch = tennisMatch;
        scores.put(1, Point.Love);
        scores.put(2, Point.Love);
    }

    @Override
    public void score(Integer player) {
        scores.put(player, scores.get(player).next());
        this.newState();
    }

    @Override
    public Score score() {
        return new Score(scores.get(1), scores.get(2), false, false);
    }

    private void newState() {
        if (scores.values().stream().anyMatch(score -> score == Point.Forty)) {
            tennisTennisMatch.setActualState(new OneToWin(scores, tennisTennisMatch));
        } else {
            tennisTennisMatch.setActualState(this);
        }
    }

}
