import java.util.List;

public class Scoreboard {

    public int points;
    public List<Integer> validPoints;

    public Scoreboard(){
        points = 0;
    }

    public void scoreAgainst(Scoreboard scoreboard2) {
        points += 1;
    }

    public Point points(){
        if(points > 3){
            points = 0;
        }return Point.values()[points];
    }
}
