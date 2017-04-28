package board.scoreboard;

import board.TennisMatch;

public class NumberOfGames {
    int playerOneSets;
    int playerTwoSets;

    public void setFor(Integer player, TennisMatch match) {
        if (player == 1) {
            playerOneSets += 1;
            this.differenceBetween(match);
        } else {
            playerTwoSets += 1;
            this.differenceBetween(match);
        }
    }

    public int getPlayerOneSets() {
        return playerOneSets;
    }
    public int getPlayerTwoSets() {
        return playerTwoSets;
    }

    public void differenceBetween(TennisMatch match) {
        int difference = playerOneSets - playerTwoSets;
        if (difference == 2 && playerOneSets >= 6)
            match.winner(1);
        else if (difference == -2 && playerTwoSets >= 6)
            match.winner(2);
    }
}
