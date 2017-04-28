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
}