public class Scoreboard {

    public int points = 0;

    public void score_against(Scoreboard scoreboard2) {
        if (points < 30) {
            points = points + 15;
        } else if (points == 30) {
            points = points + 10;
        } else if (points == 40 && scoreboard2.points < 40) {
            points = 0;
        }
    }
}
