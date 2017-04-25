import org.junit.Before;
import org.junit.Test;
import scoreboard.Pair;
import scoreboard.Point;
import scoreboard.Scoreboard;
import states.DeuceState;
import states.OnePointToWinState;
import states.GameState;
import states.PlayingState;

import static org.junit.Assert.*;

public class GameStateTest {

    private Pair<GameState, GameState> result;

    public Scoreboard scoreboard = new Scoreboard();

    @Before
    public void setUp(){
        scoreboard = new Scoreboard();
    }
    
    public Pair score(int aQuantityOfTimes){
        for (int i = 0; i < aQuantityOfTimes; i++) {
            result = scoreboard.playerOneScored();
        }
        return result;
    }

    @Test
    public void testPlayingAdvancesSelfToPLaying() {
        result = score(1);
        assertEquals(new PlayingState(Point.Fifteen), result.getX());
    }

    @Test
    public void testPlayingDontAdvancesTheOtherState() {
        result = scoreboard.playerOneScored();
        assertEquals(new PlayingState(Point.Fifteen), result.getX());
    }

    @Test
    public void testPlayingAdvancesSelfToPLayingWithTwoPoints() {
        result = scoreboard.playerTwoScored();
        result = scoreboard.playerTwoScored();
        assertEquals(new PlayingState(Point.Thirty), result.getX());
    }

    @Test
    public void testThirtyAdvancesToOnePointToWinState() {
        result = scoreboard.playerTwoScored();
        result = scoreboard.playerTwoScored();
        result = scoreboard.playerTwoScored();
        assertEquals(new OnePointToWinState(), result.getX());
    }

    @Test
    public void testBothPlayingsAdvanceTodeuce() {
        result = scoreboard.playerOneScored();
        result = scoreboard.playerOneScored();
        result = scoreboard.playerOneScored();
        result = scoreboard.playerTwoScored();
        result = scoreboard.playerTwoScored();
        result = scoreboard.playerTwoScored();
        assertEquals(new DeuceState(), result.getX());
        assertEquals(new DeuceState(), result.getY());
    }
}
