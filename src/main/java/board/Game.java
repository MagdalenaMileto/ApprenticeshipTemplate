package board;

import board.states.GameState;
import board.states.Playing;

public class Game {

    GameState actualState;

    public Game() {
        this.actualState = new Playing(this);
    }

    public void playerOneScored() {
        actualState.score(1);
    }

    public void playerTwoScored() {
        actualState.score(2);
    }

    public void newSet(Integer player) {
        //Lógica para sumar el set va acá
        System.out.println(player);
        this.setActualState(new Playing(this));
    }

    public void setActualState(GameState actualState) {
        this.actualState = actualState;
    }

    public GameState getActualState() {
        return actualState;
    }

    public Score getScore() {
        return actualState.actualScore();
    }
}
