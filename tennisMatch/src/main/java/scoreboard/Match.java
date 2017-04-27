package scoreboard;

import scoreboard.score.Scoreboard;
import states.GameStateMachine;

public class Match {

    Scoreboard scoreboard;
    GameStateMachine gameStatus;

    public Match(Scoreboard _scoreboard, GameStateMachine _gameStatus){
        scoreboard = _scoreboard;
        gameStatus = _gameStatus;
    }

    public void playerOneScored(){
        scoreboard.playerOneScored();
    }
    public void playerTwoScored() {
        scoreboard.playerTwoScored();
    }

    public void status(){
        gameStatus = scoreboard.getGameStatus();
    }

    public GameStateMachine getGameStatus(){
        return gameStatus;
    }
}
