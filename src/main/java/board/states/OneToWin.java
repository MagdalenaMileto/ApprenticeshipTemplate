package board.states;

import board.Game;
import board.Point;

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

    private AbstractMap.SimpleEntry<Integer, Point> toTuple(Integer player, Point score) {
        return new AbstractMap.SimpleEntry<>(player, score);
    }
}
