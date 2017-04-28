import board.Game;
import board.Point;
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

    public void score(Integer aQuantityOfTimes) {
        for (int i = 0; i < aQuantityOfTimes; i++) {
            game.playerOneScored();
        }
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresOneTime() {
        score(1);
        assertEquals(game.getActualState(), new Playing(game));
    }

    @Test
    public void testPlayingAdvancesToPLayingWhenScoresTwoTimes() {
        score(2);
        assertEquals(game.getActualState(), new Playing(game));
    }

    @Test
    public void testPlayingAdvancesToOneToWinWhenScoresTreeTimes() {
        score(3);
        assertEquals(game.getActualState(), new OneToWin(previousScore, game));
    }

}
