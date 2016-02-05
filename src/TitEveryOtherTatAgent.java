import java.util.List;

/**
 * Created by Andreas on 05.02.2016.
 */
public class TitEveryOtherTatAgent implements Agent {
    /*
    Defects if the last two actions of opponent was defect
     */
    @Override
    public Action dilemma(List<Action> opponentPreviousActions){
        int n = opponentPreviousActions.size();

        if(n<=1){return Action.COOPERATE;}

        if (opponentPreviousActions.get(n-1) == Action.DEFECT &&
                opponentPreviousActions.get(n-2) == Action.DEFECT) {
            return Action.DEFECT;
        }
        return Action.COOPERATE;
    }
}
