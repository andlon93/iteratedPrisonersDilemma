import java.util.List;

/**
 * Created by Andreas on 05.02.2016.
 */
public class DefectAgent implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions){
        return Action.DEFECT;
    }
}
