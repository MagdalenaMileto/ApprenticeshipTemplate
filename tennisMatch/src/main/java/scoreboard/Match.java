package scoreboard;

import scoreboard.score.Scoreboard;
import states.GameState;

public class Match {

    Scoreboard scoreboard;
    GameState gameStatus;
    Integer setsPlayer1;
    Integer setsPlayer2;

    public Match(Scoreboard _scoreboard, GameState _gameStatus) {
        scoreboard = _scoreboard;
        gameStatus = _gameStatus;
    }

    public void status() {
        gameStatus = scoreboard.getGameStatus();
    }

    public GameState getGameStatus() {
        return gameStatus;
    }
    public Match getMatchStatus() {
        return this;
    }
}
