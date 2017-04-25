package states;
import scoreboard.Pair;

public class AdvantageState extends Forty {

    public Pair goBackToDeuce(GameState otherState){
        return new Pair <GameState, GameState>(new DeuceState(), otherState);
    }

    public Boolean advantage(){
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == AdvantageState.class;
    }
}
