package board;

import board.scoreboard.NumberOfGames;
import board.scoreboard.Score;
import board.states.GameState;
import board.states.Playing;

public class TennisMatch {

    GameState actualState;
    NumberOfGames games;

    public TennisMatch(NumberOfGames games2) {
        this.actualState = new Playing(this);
        this.games = games2;
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

    public void winner(int playerNumber){
        System.out.println("The winner is player number"+ playerNumber);
        games = new NumberOfGames();
        new TennisMatch(games);
    }

    public void newSet(Integer player) {
        games.setFor(player, this);
        this.setActualState(new Playing(this));
    }
    public void setActualState(GameState actualState) {
        this.actualState = actualState;
    }
}
