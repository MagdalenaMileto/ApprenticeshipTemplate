package board;

import board.states.GameState;
import board.states.Playing;

public class Game {

    GameState actualState;
    GameSets sets;

    public Game() {
        this.actualState = new Playing(this);
        this.sets = new GameSets();
    }

    public void playerOneScored() {
        actualState.score(1);
    }

    public void playerTwoScored() {
        actualState.score(2);
    }

    public Score score() {
        return actualState.score();
    }

    public void newSet(Integer player) {
        sets.setFor(player);
        this.setActualState(new Playing(this));
    }

    public void setActualState(GameState actualState) {
        this.actualState = actualState;
    }
}
