package board.scoreboard;

public class NumberOfGames {
    int playerOneSets;
    int playerTwoSets;

    public void setFor(Integer player) {
        if (player == 1)
            playerOneSets += 1;
        else
            playerTwoSets += 1;
    }

    public int getPlayerOneSets(){
        return playerOneSets;
    }

    public int getPlayerTwoSets() {
        return playerTwoSets;
    }
}
