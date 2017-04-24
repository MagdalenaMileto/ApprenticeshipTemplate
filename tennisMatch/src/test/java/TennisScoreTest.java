import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisScoreTest {

    Scoreboard scoreboardPlayer1;
    Scoreboard scoreboardPlayer2;

    @Before
    public void setUp() {
        scoreboardPlayer1 = new Scoreboard();
        scoreboardPlayer2 = new Scoreboard();
    }

    public void scorePoints(int quantity, Scoreboard scoreboard, Scoreboard scoreboardPlayer2) {
        for (int i = 0; i < quantity; i++) {
            scoreboard.scoreAgainst(scoreboardPlayer2);
        }
    }

    @Test
    public void testScoreStartsIn0() {
        Assert.assertEquals(Point.Love, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes0To15() {
        scorePoints(1, scoreboardPlayer1, scoreboardPlayer2);
        Assert.assertEquals(Point.Fiftheen, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes15To30() {
        scorePoints(2, scoreboardPlayer1, scoreboardPlayer2);
        Assert.assertEquals(30, scoreboardPlayer1.points);
    }

    @Test
    public void testScoreGoes30To40() {
        scorePoints(3, scoreboardPlayer1, scoreboardPlayer2);
        Assert.assertEquals(40, scoreboardPlayer1.points);
    }

    @Test
    public void testScorePlayer1Goes40To0IfPlayer2HaveLessThan40Points() {
        scorePoints(4, scoreboardPlayer1, scoreboardPlayer2);
        scorePoints(1, scoreboardPlayer2, scoreboardPlayer1);
        Assert.assertEquals(0, scoreboardPlayer1.points);
        Assert.assertEquals(15, scoreboardPlayer2.points);
    }

    @Test
    public void testScorePlayer1Goes40ToAdvantageIfPlayer2Have40Points() {
        scorePoints(4, scoreboardPlayer1, scoreboardPlayer2);
        scorePoints(4, scoreboardPlayer2, scoreboardPlayer1);
        Assert.assertEquals(0, scoreboardPlayer1.points);
        Assert.assertEquals(15, scoreboardPlayer2.points);
    }
}
