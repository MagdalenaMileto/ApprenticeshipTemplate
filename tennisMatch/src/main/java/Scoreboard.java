public class Scoreboard {

    int points = 0;

    public void score() {
        if (points < 30) {
            points = points + 15;
        }
    }

    public int points() {
        return points;
    }
}
