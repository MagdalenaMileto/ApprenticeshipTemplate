import org.junit.Before;
import org.junit.Test;
import scoreboard.Pair;
import scoreboard.Point;
import scoreboard.Scoreboard;
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

    @Test
    public void testPlayingAdvancesSelfToPLaying() {
        result = scoreboard.playerOneScored();
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
}
