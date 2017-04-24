import org.junit.Test;
import scoreboard.Pair;
import scoreboard.Point;
import states.Advantage;
import states.GameState;
import states.Playing;

import static org.junit.Assert.*;

public class GameStateTest {

    private Pair<GameState, GameState> result;

    @Test
    public void playingAdvancesSelfToPLaying() {
        result = new Playing().pointAgainst(new Playing());
        assertEquals(new Playing(Point.Fifteen), result.getX());
    }

    @Test
    public void playingDontAdvancesTheOtherState() {
        result = new Playing().pointAgainst(new Playing());
        assertEquals(new Playing(Point.Fifteen), result.getX());
    }

    @Test
    public void thirtyAdvancesToAdvantage() {
        result = new Playing(Point.Thirty).pointAgainst(new Playing());
        assertEquals(new Advantage(), result.getX());
    }

}
