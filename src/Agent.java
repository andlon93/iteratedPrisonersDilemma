import java.util.List;

/**
 * Created by Andreas on 05.02.2016.
 */
public interface Agent {
    public enum Action{ COOPERATE, DEFECT}

    Action dilemma(List<Action> opponentPreviousActions);
}
