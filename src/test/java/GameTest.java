import board.Game;
import board.Point;
import board.Score;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    HashMap<Integer, Point> previousScore;

    @Before
    public void setUp() {
        game = new Game();
        previousScore = new HashMap<Integer, Point>();
    }

    public void scorePlayerOne(Integer aQuantityOfTimes) {
        for (int i = 0; i < aQuantityOfTimes; i++) {
            game.playerOneScored();
        }
    }

    public void scorePlayerTwo(Integer aQuantityOfTimes) {
        for (int i = 0; i < aQuantityOfTimes; i++) {
            game.playerTwoScored();
        }
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresOneTime() {
        scorePlayerOne(1);
        assertEquals(game.score(), new Score(Point.Fifteen, Point.Love, false, false));
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresTwoTimes() {
        scorePlayerOne(2);
        assertEquals(game.score(), new Score(Point.Thirty, Point.Love, false, false));
    }

    @Test
    public void testPlayingAdvancesToOneToWinWhenScoresTreeTimes() {
        scorePlayerOne(3);
        assertEquals(game.score(), new Score(Point.Forty, Point.Love, false, false));
    }

    @Test
    public void testBothPlayingsAdvanceTosDeuce(){
        scorePlayerOne(3);
        scorePlayerTwo(3);
        assertEquals(game.score(), new Score(Point.Forty, Point.Forty, false, false));
    }

}
