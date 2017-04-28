package board.states;

import board.scoreboard.Score;

public interface GameState {
    void score(Integer player);

    Score score();
}
