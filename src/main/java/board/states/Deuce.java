package board.states;

import board.Game;
import board.Point;
import board.Score;

public class Deuce implements GameState {

    Integer playerWithAdvantage;
    Boolean tied;
    Game tennisGame;

    public Deuce(Game game) {
        tennisGame = game;
        tied = true;
    }

    @Override
    public void score(Integer player) {
        if (tied) {
            playerWithAdvantage = player;
            tied = false;
        } else {
            if (playerWithAdvantage == player) {
                tennisGame.newSet(player);
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
