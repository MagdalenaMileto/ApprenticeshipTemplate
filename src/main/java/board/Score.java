package board;

public class Score {
    Point player1Points;
    Point player2Points;
    Boolean player1Advantage;
    Boolean player2Advantage;

    public Score(Point player1Points, Point player2Points, Boolean player1Advantage, Boolean player2Advantage) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.player1Advantage = player1Advantage;
        this.player2Advantage = player2Advantage;
    }

    @Override
    public String toString() {
        return "Score{" +
                "player1Points=" + player1Points +
                ", player2Points=" + player2Points +
                ", player1Advantage=" + player1Advantage +
                ", player2Advantage=" + player2Advantage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (player1Points != score.player1Points) return false;
        if (player2Points != score.player2Points) return false;
        if (!player1Advantage.equals(score.player1Advantage)) return false;
        return player2Advantage.equals(score.player2Advantage);
    }

    @Override
    public int hashCode() {
        int result = player1Points.hashCode();
        result = 31 * result + player2Points.hashCode();
        result = 31 * result + player1Advantage.hashCode();
        result = 31 * result + player2Advantage.hashCode();
        return result;
    }
}