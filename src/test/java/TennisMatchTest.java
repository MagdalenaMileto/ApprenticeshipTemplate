import board.TennisMatch;
import board.scoreboard.NumberOfGames;
import board.scoreboard.Point;
import board.scoreboard.Score;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TennisMatchTest {

    TennisMatch tennisMatch;
    HashMap<Integer, Point> previousScore;
    NumberOfGames games = new NumberOfGames();

    @Before
    public void setUp() {
        tennisMatch = new TennisMatch(games);
        previousScore = new HashMap<Integer, Point>();


    }

    public void scorePlayerOne(Integer aQuantityOfTimes) {
        for (int i = 0; i < aQuantityOfTimes; i++) {
            tennisMatch.playerOneScored();
        }
    }

    public void scorePlayerTwo(Integer aQuantityOfTimes) {
        for (int i = 0; i < aQuantityOfTimes; i++) {
            tennisMatch.playerTwoScored();
        }
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresOneTime() {
        scorePlayerOne(1);
        assertEquals(tennisMatch.score(), new Score(Point.Fifteen, Point.Love, false, false));
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresTwoTimes() {
        scorePlayerOne(2);
        assertEquals(tennisMatch.score(), new Score(Point.Thirty, Point.Love, false, false));
    }

    @Test
    public void testPlayingAdvancesToOneToWinWhenScoresTreeTimes() {
        scorePlayerOne(3);
        assertEquals(tennisMatch.score(), new Score(Point.Forty, Point.Love, false, false));
    }

    @Test
    public void testBothPlayingsAdvanceTosDeuce() {
        scorePlayerOne(3);
        scorePlayerTwo(3);
        assertEquals(tennisMatch.score(), new Score(Point.Forty, Point.Forty, false, false));
    }

    @Test
    public void testBothPlayersInDeucePlayerOneScoresAndNowIsAdvantage() {
        scorePlayerOne(3);
        scorePlayerTwo(3);
        scorePlayerOne(1);
        assertEquals(tennisMatch.score(), new Score(Point.Forty, Point.Forty, true, false));
    }

    @Test
    public void testAdvatangeWinsOverDeuceAndBothReturnToPlayingState() {
        scorePlayerOne(3);
        scorePlayerTwo(3);
        scorePlayerOne(2);
        assertEquals(tennisMatch.score(), new Score(Point.Love, Point.Love, false, false));

    }

    @Test
    public void testOnePlayerIsAdvanceAndTheOtherOneScoresAPointTheOneInAdvanceReturnsToForty() {
        scorePlayerOne(3);
        scorePlayerTwo(3);
        scorePlayerOne(1);
        scorePlayerTwo(1);
        assertEquals(tennisMatch.score(), new Score(Point.Forty, Point.Forty, false, false));
    }

    @Test
    public void testOnePlayerWinsAGameDirectly() {
        scorePlayerOne(4);
        assertEquals(games.getPlayerOneSets(), 1);
    }

    @Test
    public void testOnePlayerWinsTwoGamesDirectly() {
        scorePlayerOne(8);
        assertEquals(games.getPlayerOneSets(), 2);
    }

    @Test
    public void testOnePlayerWinsTwoGamesDirectlyAndThePlayerTwoWinsOne() {
        scorePlayerOne(8);
        scorePlayerTwo(4);
        assertEquals(games.getPlayerOneSets(), 2);
        assertEquals(games.getPlayerTwoSets(), 1);
    }

    @Test
    public void testOnePlayerWinsOneGameAfterADeuce() {
        scorePlayerOne(3);
        scorePlayerTwo(3);
        scorePlayerOne(2);
        assertEquals(games.getPlayerOneSets(), 1);
        assertEquals(games.getPlayerTwoSets(), 0);
    }

    @Test
    public void testTwoPlayerWinsOneGameAfterALotOfAdvantages() {
        scorePlayerOne(3);
        scorePlayerTwo(3);
        scorePlayerOne(1);
        scorePlayerTwo(1);
        scorePlayerOne(1);
        scorePlayerTwo(1);
        scorePlayerOne(1);
        scorePlayerTwo(1);
        scorePlayerTwo(1);
        scorePlayerTwo(1);
        assertEquals(games.getPlayerOneSets(), 0);
        assertEquals(games.getPlayerTwoSets(), 1);
    }

    @Test
    public void TestOnePlayerReachSixAndDoesntWinBecauseTheOtherHasFive(){
        scorePlayerOne(20);
        scorePlayerTwo(24);
        assertEquals(games.getPlayerOneSets(), 5);
        assertEquals(games.getPlayerTwoSets(), 6);

    }

    @Test
    public void TestOnePlayerReachSevenAndWinsBecauseTheOtherHasFive(){
        scorePlayerOne(20);
        scorePlayerTwo(30);
        assertEquals(games.getPlayerOneSets(), 5);
        assertEquals(games.getPlayerTwoSets(), 7);
    }
    @Test
    public void TestTennisMatchStopsWhenAPlayerWins(){
        scorePlayerOne(20);
        //Se queda en 7 por más que siga escoreando porque el 2 ya ganó y se corta el flujo.
        scorePlayerTwo(40);
        assertEquals(games.getPlayerOneSets(), 5);
        assertEquals(games.getPlayerTwoSets(), 7);

    }

}
