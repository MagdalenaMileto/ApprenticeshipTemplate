package board.states;

import board.Score;

public interface GameState {
    void score(Integer player);

    Score score();
}
