import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisScoreTest {

    Scoreboard scoreboardPlayer1;

    @Before
    public void setUp(){
        scoreboardPlayer1 = new Scoreboard();
    }

    public void scorePoints(int quantity, Scoreboard scoreboard){
        for (int i = 0; i < quantity; i++) {
            scoreboard.score();
        }
    }

    @Test
    public void testScoreStartsIn0(){
        Assert.assertEquals(0, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes0To15(){
        scorePoints(1, scoreboardPlayer1);
        Assert.assertEquals(15, scoreboardPlayer1.points());
    }

    @Test
    public void testScoreGoes15To30(){
        scorePoints(2, scoreboardPlayer1);
        Assert.assertEquals(30, scoreboardPlayer1.points());

    }
}
