import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ole on 05.02.2016.
 */
public class Main {

    public static void main (String[] args){

    }

    private double[] playMatches(Agent a1, Agent a2, int numberOfRounds){
        ArrayList<Agent.Action> a1Moves = new ArrayList<Agent.Action>();
        ArrayList<Agent.Action> a2Moves = new ArrayList<Agent.Action>();

        int a1Payoff = 0;
        int a2Payoff = 0;

        for (int i=0; i<numberOfRounds; i++){
            Agent.Action a1Move = a1.dilemma(a2Moves);
            Agent.Action a2Move = a2.dilemma(a1Moves);
            if (a1Move.equals(Agent.Action.DEFECT)){
                if (a2Move.equals(Agent.Action.DEFECT)){
                    a1Payoff += 2;
                    a2Payoff += 2;}
                else{
                    a1Payoff += 5;}}
            else {
                if (a2Move.equals(Agent.Action.DEFECT)){
                    a2Payoff += 5;}
                else{
                    a1Payoff += 3;
                    a2Payoff += 3;}}
            a1Moves.add(a1Move);
            a2Moves.add(a2Move);
        }
        double[] scores = {a1Payoff/numberOfRounds,a2Payoff/numberOfRounds};
        return scores;
    }

    private void playTournament(Agent[] agents){
        for (Agent a1: agents){

        }

    }
}
