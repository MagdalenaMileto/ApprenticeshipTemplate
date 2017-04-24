import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
public class TennisScoreTest {

    scoreboard.Scoreboard scoreboardPlayer1;
    scoreboard.Scoreboard scoreboardPlayer2;

    @Before
    public void setUp() {
        scoreboardPlayer1 = new scoreboard.Scoreboard();
        scoreboardPlayer2 = new scoreboard.Scoreboard();
    }

    public void scorePoints(int quantity, scoreboard.Scoreboard scoreboard, scoreboard.Scoreboard scoreboardPlayer2) {
        for (int i = 0; i < quantity; i++) {
            scoreboard.scoreAgainst(scoreboardPlayer2);
        }
    }

    @Test
    public void] testScoreStartsIn0() {
        Assert.assertEquals(scoreboard.Point.Love, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes0To15() {
        scorePoints(1, scoreboardPlayer1, scoreboardPlayer2);
        Assert.assertEquals(scoreboard.Point.Fifteen, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes15To30() {
        scorePoints(2, scoreboardPlayer1, scoreboardPlayer2);
        Assert.assertEquals(scoreboard.Point.Thirty, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes30To40() {
        scorePoints(3, scoreboardPlayer1, scoreboardPlayer2);
        Assert.assertEquals(scoreboard.Point.Forty, scoreboardPlayer1.points());
    }

    @Test
    public void testScorePlayer1Goes40To0IfPlayer2HaveLessThan40Points() {
        scorePoints(4, scoreboardPlayer1, scoreboardPlayer2);
        scorePoints(1, scoreboardPlayer2, scoreboardPlayer1);
        Assert.assertEquals(scoreboard.Point.Love, scoreboardPlayer1.points());
        Assert.assertEquals(scoreboard.Point.Fifteen, scoreboardPlayer2.points());
    }

    @Test
    public void testScorePlayer1Goes40ToAdvantageIfPlayer2Have40Points() {
        scorePoints(3, scoreboardPlayer1, scoreboardPlayer2);
        scorePoints(3, scoreboardPlayer2, scoreboardPlayer1);
        scoreboardPlayer1.scoreAgainst(scoreboardPlayer2);
        Assert.assertEquals(scoreboard.Point.states.Advantage, scoreboardPlayer1.points());
        Assert.assertEquals(scoreboard.Point.Forty, scoreboardPlayer2.points());
    }
}
*/