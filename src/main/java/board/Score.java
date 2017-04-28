package board;

public class Score {

    Point playerOneScore;
    Point playerTwoScore;
    Boolean advantagePlayerOne;
    Boolean advantagePlayerTwo;

    public Score(Point playerOneScore2, Point playerTwoScore2, Boolean advantagePlayerOne2, Boolean advantagePlayerTwo2) {
        playerOneScore = playerOneScore2;
        playerTwoScore = playerTwoScore2;
        advantagePlayerOne = advantagePlayerOne2;
        advantagePlayerTwo = advantagePlayerTwo2;

    }
}
