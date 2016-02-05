import java.util.List;
import java.util.Random;

/**
 * Created by Andreas on 05.02.2016.
 */
public class MoveProbEqualOpponentsMoveProb implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        Random rng = new Random();
        int n = opponentPreviousActions.size();

        //if it is the first move -> 80% of ccoperating
        if(n==0){int rn = rng.nextInt(10);if (rn < 8){return Action.COOPERATE;}}

        //count number of coops for opponent
        int numberOfCoops = 0;
        for (Action a : opponentPreviousActions){
            if (a == Action.COOPERATE){numberOfCoops++;}
        }
        int rn = rng.nextInt(n);

        //do action with same prob as opponent
        if (rn < numberOfCoops){return Action.COOPERATE;}
        else {return Action.DEFECT;}
    }
}
