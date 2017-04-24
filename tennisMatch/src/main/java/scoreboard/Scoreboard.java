package scoreboard;

import states.GameState;
import states.Playing;

public class Scoreboard {

    GameState player1State = new Playing();
    GameState player2State = new Playing();

    public void playerOneScored() {
        Pair<GameState, GameState> result = player1State.pointAgainst(player2State);
        player1State = result.getX();
        player2State = result.getY();

    }

    public void playerTwoScored() {
        Pair<GameState, GameState> result = player2State.pointAgainst(player1State);
        player2State = result.getX();
        player1State = result.getY();
    }
}
