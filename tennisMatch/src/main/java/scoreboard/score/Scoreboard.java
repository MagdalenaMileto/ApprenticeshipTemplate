package scoreboard.score;

import states.AdvantageState;
import states.DeuceState;
import states.GameStateMachine;
import states.PlayingState;

public class Scoreboard {

    GameStateMachine player1State = new PlayingState();
    GameStateMachine player2State = new PlayingState();

    public Pair playerOneScored() {
        Pair<GameStateMachine, GameStateMachine> result = player1State.pointsAgainst(player2State);
        player1State = result.getX();
        player2State = result.getY();
        return result;
    }
    public Pair playerTwoScored() {
        Pair<GameStateMachine, GameStateMachine> result = player2State.pointsAgainst(player1State);
        player2State = result.getX();
        player1State = result.getY();
        return result;
    }

    public GameStateMachine getGameStatus(){
        if(player1State.forty() && player2State.forty()){
            return new DeuceState();
        }else if(player1State.advantage() || player2State.advantage()){
            return new AdvantageState();
        }else
            return new PlayingState();
    }


}
