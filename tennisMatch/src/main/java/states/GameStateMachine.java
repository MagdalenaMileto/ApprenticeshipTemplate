package states;

import scoreboard.Pair;

public interface GameStateMachine {
    Pair<GameStateMachine, GameStateMachine> pointsAgainst(GameStateMachine otherState);

    Boolean forty();
    Boolean advantage();
}