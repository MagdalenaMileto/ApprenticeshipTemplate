package board.states;

import board.Game;
import board.Point;
import board.Score;

import java.util.HashMap;

public class Playing implements GameState {

    HashMap<Integer, Point> scores = new HashMap<>();
    Game tennisGame;

    public Playing(Game game) {
        tennisGame = game;
        scores.put(1, Point.Love);
        scores.put(2, Point.Love);
    }

    @Override
    public void score(Integer player) {
        scores.put(player, scores.get(player).next());
        this.newState();
    }

    private void newState() {
        if (scores.values().stream().anyMatch(score -> score == Point.Forty)) {
            tennisGame.setActualState(new OneToWin(scores, tennisGame));
        } else {
            tennisGame.setActualState(this);
        }
    }

}
