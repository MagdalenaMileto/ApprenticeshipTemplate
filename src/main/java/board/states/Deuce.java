package board.states;

import board.Game;

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
}
