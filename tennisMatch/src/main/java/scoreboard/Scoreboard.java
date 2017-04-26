package scoreboard;

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
}
