import org.junit.Before;
import org.junit.Test;
import scoreboard.Match;
import scoreboard.score.Pair;
import scoreboard.score.Point;
import scoreboard.score.Scoreboard;
import states.*;

import static org.junit.Assert.*;

public class GameStateMachineTest {

    private Pair<GameStateMachine, GameStateMachine> result;
    private Pair<GameStateMachine, GameStateMachine> result2;

    public Scoreboard scoreboard = new Scoreboard();

    GameStateMachine gameStatus;

    public Match match = new Match(scoreboard, gameStatus);

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
        assertEquals(new FortyState(), result.getX());
    }

    @Test
    public void testBothPlayingsAdvanceToDeuce() {
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        assertEquals(new DeuceState(), result.getX());
        assertEquals(new DeuceState(), result.getY());
    }

    @Test
    public void testDeuceAdvanceToAdvantageState(){
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        result = scorePlayerOne(1);
        assertEquals(new AdvantageState(), result.getX());
        assertEquals(new DeuceState(), result.getY());
    }

    @Test
    public void testAdvatangeWinsOverDeuceAndBothReturnToPlayingState(){
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        result = scorePlayerOne(2);
        assertEquals(new PlayingState(Point.Love), result.getX());
        assertEquals(new PlayingState(Point.Love), result.getY());
    }

    @Test
    public void testOnePlayerIsAdvanceAndTheOtherOneScoresAPointTheOneInAdvanceReturnsToForty(){
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        result = scorePlayerOne(1);
        result = scorePlayerTwo(1);
        assertEquals(new DeuceState(), result.getX());
        assertEquals(new DeuceState(), result.getY());
    }

    @Test
    public void testGameStatusPlayingState(){
        scorePlayerOne(2);
        match.status();
        assertEquals(match.getGameStatus(), new PlayingState());
    }

    @Test
    public void testGameStatusReachFortyState(){
        result = scorePlayerOne(3);
        match.status();
        assertEquals(match.getGameStatus(), new PlayingState());
    }

    @Test
    public void testGameStatusDeuceState(){
        result = scorePlayerOne(3);
        result2 = scorePlayerTwo(3);
        match.status();
        assertEquals(match.getGameStatus(), new DeuceState());
    }

    @Test
    public void testGameStatusAdvantageState(){
        scorePlayerOne(3);
        scorePlayerTwo(3);
        scorePlayerOne(1);
        match.status();
        assertEquals(match.getGameStatus(), new AdvantageState());
    }
}
