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
    private Pair<GameState, GameState> result2;

    public Scoreboard scoreboard = new Scoreboard();

    @Before
    public void setUp(){
        scoreboard = new Scoreboard();
    }
    
    public Pair scorePlayerOne(int aQuantityOfTimes){
        for (int i = 0; i < aQuantityOfTimes; i++) {
            result = scoreboard.playerOneScored();
        }
        return result;
    }
    public Pair scorePlayerTwo(int aQuantityOfTimes){
        for (int i = 0; i < aQuantityOfTimes; i++) {
            result = scoreboard.playerTwoScored();
        }
        return result;
    }

    @Test
    public void testPlayingAdvancesSelfToPLaying() {
        result = scorePlayerOne(1);
        assertEquals(new PlayingState(Point.Fifteen), result.getX());
    }

    @Test
    public void testPlayingDontAdvancesTheOtherState() {
        result = scorePlayerOne(1);
        assertEquals(new PlayingState(Point.Fifteen), result.getX());
    }

    @Test
    public void testPlayingAdvancesSelfToPLayingWithTwoPoints() {
        result = scorePlayerOne(2);
        assertEquals(new PlayingState(Point.Thirty), result.getX());
    }

    @Test
    public void testThirtyAdvancesToOnePointToWinState() {
        result2 = scorePlayerTwo(3);
        assertEquals(new OnePointToWinState(), result.getX());
    }

    @Test
    public void testBothPlayingsAdvanceToDeuce() {
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        assertEquals(new DeuceState(), result.getX());
        assertEquals(new DeuceState(), result.getY());
    }

    @Test
    public void testForthyAdvanceToOnePointToWinStateWhenTheOtherIsInForthyToo(){
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        result = scorePlayerOne(1);
        assertEquals(new OnePointToWinState(), result.getX());
        assertEquals(new DeuceState(), result.getY());
    }

    @Test
    public void testAdvanceToOnePointWinsOverDeuceAndBothReturnToPlayingState(){
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        result = scorePlayerOne(2);
        assertEquals(new PlayingState(), result.getX());
        assertEquals(new PlayingState(), result.getY());
    }
}
