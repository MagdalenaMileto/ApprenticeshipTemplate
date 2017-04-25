package states;
import scoreboard.Pair;

public class Advantage extends Forty {

    public Pair goBackToDeuce(GameState otherState){
        return new Pair <GameState, GameState>(new DeuceState(), otherState);
    }

    public Boolean advantage(){
        return true;
    }
}
