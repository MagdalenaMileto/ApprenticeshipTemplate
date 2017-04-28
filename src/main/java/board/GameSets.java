package board;

public class GameSets {
    int playerOneSets = 0;
    int playerTwoSets = 0;

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
