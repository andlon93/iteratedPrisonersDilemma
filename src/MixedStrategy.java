import java.util.List;
import java.util.Random;

/**
 * Created by Andreas on 05.02.2016.
 */
public class MixedStrategy implements Agent {
    /*
    use a mixed strategy of tit for tat and tit for every other tat
     */

    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        int n = opponentPreviousActions.size();
        Random rng = new Random();
        int rn = rng.nextInt(10);
        if (rn <= 4){return titForTat(opponentPreviousActions);}
        else{return titEveryOtherTat(opponentPreviousActions);}
    }

    private Action titEveryOtherTat(List<Action> opponentPreviousActions){
        int n = opponentPreviousActions.size();
        if (opponentPreviousActions.get(n-1) == Action.DEFECT &&
                opponentPreviousActions.get(n-2) == Action.DEFECT) {
            return Action.DEFECT;
        }
        return Action.COOPERATE;
    }

    private Action titForTat(List<Action> opponentPreviousActions){
        int lentgh = opponentPreviousActions.size();
        if (lentgh == 0){return Action.COOPERATE;}
        else{return opponentPreviousActions.get(lentgh-1);}
    }
}
