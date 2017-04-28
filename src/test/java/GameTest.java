import board.Game;
import board.Point;
import board.states.Deuce;
import board.states.OneToWin;
import board.states.Playing;
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
        assertEquals(game.getActualState(), new Playing(game));
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresTwoTimes() {
        scorePlayerOne(2);
        assertEquals(game.getActualState(), new Playing(game));
    }

    @Test
    public void testPlayingAdvancesToOneToWinWhenScoresTreeTimes() {
        scorePlayerOne(3);
        assertEquals(game.getActualState(), new OneToWin(previousScore, game));
    }

    @Test
    public void testBothPlayingsAdvanceToDeuce(){
        scorePlayerOne(3);
        scorePlayerTwo(3);
        assertEquals(game.getActualState(), new Deuce(game));
    }

}
