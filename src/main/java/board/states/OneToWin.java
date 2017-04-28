package board.states;

import board.Game;
import board.Point;
import board.Score;

import java.util.AbstractMap;
import java.util.HashMap;

public class OneToWin implements GameState {

    AbstractMap.SimpleEntry<Integer, Point> closeToWin;
    AbstractMap.SimpleEntry<Integer, Point> otherPlayer;

    Game tennisGame;

    public OneToWin(HashMap<Integer, Point> previousScore, Game game) {
        tennisGame = game;
        previousScore.forEach((player, score) -> {
                    if (score == Point.Forty) {
                        closeToWin = toTuple(player, score);
                    } else {
                        otherPlayer = toTuple(player, score);
                    }
                }
        );
    }

    @Override
    public void score(Integer player) {
        if (closeToWin.getKey() == player) {
            tennisGame.newSet(closeToWin.getKey());
        } else {
            if (otherPlayer.getValue() == Point.Thirty) {
                tennisGame.setActualState(new Deuce(tennisGame));
            } else {
                otherPlayer.setValue(otherPlayer.getValue().next());
            }
        }
    }

    @Override
    public Score score() {
        //Les pongo null porque sino me dice que no los inicié
        Point scorePlayer1 = null;
        Point scorePlayer2 = null;
        if (closeToWin.getKey() == 1) {
            scorePlayer1 = closeToWin.getValue();
        } else {
            scorePlayer2 = closeToWin.getValue();
        }

        if (otherPlayer.getKey() == 1) {
            scorePlayer1 = otherPlayer.getValue();
        } else {
            scorePlayer2 = otherPlayer.getValue();
        }

        return new Score(scorePlayer1, scorePlayer2, false, false);
    }

    private AbstractMap.SimpleEntry<Integer, Point> toTuple(Integer player, Point score) {
        return new AbstractMap.SimpleEntry<>(player, score);
    }
}
