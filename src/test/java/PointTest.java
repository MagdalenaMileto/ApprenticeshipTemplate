import board.scoreboard.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void nextReturnsTheNextPoint() {
        Point love = Point.Love;
        assertEquals(Point.Fifteen, love.next());
    }

    @Test
    public void nextOfFortyReturnsLove() {
        Point forty = Point.Forty;
        assertEquals(Point.Love, forty.next());
    }
}
