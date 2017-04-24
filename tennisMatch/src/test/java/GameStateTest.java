import org.junit.Test;
import scoreboard.Pair;
import scoreboard.Point;
import states.OnePointToWinState;
import states.GameState;
import states.PlayingState;

import static org.junit.Assert.*;

public class GameStateTest {

    private Pair<GameState, GameState> result;

    @Test
    public void testPlayingAdvancesSelfToPLaying() {
        result = new PlayingState().pointsAgainst(new PlayingState());
        assertEquals(new PlayingState(Point.Fifteen), result.getX());
    }

    @Test
    public void testPlayingDontAdvancesTheOtherState() {
        result = new PlayingState().pointsAgainst(new PlayingState());
        assertEquals(new PlayingState(Point.Fifteen), result.getX());
    }

    @Test
    public void testThirtyAdvancesToOnePointToWinState() {
        result = new PlayingState(Point.Thirty).pointsAgainst(new PlayingState());
        assertEquals(new OnePointToWinState(), result.getX());
    }
}
