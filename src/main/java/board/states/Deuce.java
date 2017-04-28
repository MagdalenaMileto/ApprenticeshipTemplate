package board.states;

import board.TennisMatch;
import board.scoreboard.Point;
import board.scoreboard.Score;

public class Deuce implements GameState {

    Integer playerWithAdvantage;
    Boolean tied;
    TennisMatch tennisTennisMatch;

    public Deuce(TennisMatch tennisMatch) {
        tennisTennisMatch = tennisMatch;
        tied = true;
    }

    @Override
    public void score(Integer player) {
        if (tied) {
            playerWithAdvantage = player;
            tied = false;
        } else {
            if (playerWithAdvantage == player) {
                tennisTennisMatch.newSet(player);
            } else {
                tied = true;
            }
        }
    }

    @Override
    public Score score() {
        Point forty = Point.Forty;
        if (tied) {
            return new Score(forty, forty, false, false);
        } else if (playerWithAdvantage == 1) {
            return new Score(forty, forty, true, false);
        } else {
            return new Score(forty, forty, false, true);
        }
    }
}
