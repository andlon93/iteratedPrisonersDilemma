import java.util.List;

/**
 * Created by Andreas on 05.02.2016.
 */
public class TitForTAtAgent implements Agent{
    /*
    Tit for tat choose coop first, then choose,
    then choose the same as opponent chose last time.
     */
    @Override
    public Action dilemma(List<Action> opponentPreviousActions){
        int lentgh = opponentPreviousActions.size();
        if (lentgh == 0){return Action.COOPERATE;}
        else{return opponentPreviousActions.get(lentgh-1);}
    }
}
