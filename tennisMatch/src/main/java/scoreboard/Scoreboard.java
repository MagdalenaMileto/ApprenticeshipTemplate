package scoreboard;

import states.GameState;
import states.PlayingState;

public class Scoreboard {

    GameState player1State = new PlayingState();
    GameState player2State = new PlayingState();

    public Pair playerOneScored() {
        Pair<GameState, GameState> result = player1State.pointsAgainst(player2State);
        player1State = result.getX();
        player2State = result.getY();
        return result;
    }

    public Pair playerTwoScored() {
        Pair<GameState, GameState> result = player2State.pointsAgainst(player1State);
        player2State = result.getX();
        player1State = result.getY();
        return result;
    }
}
