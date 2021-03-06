import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ole on 05.02.2016.
 */
public class Main {

    public static void main (String[] args){
        Agent[] agents = new Agent[6];
        agents[0]= new CoopAgent();
        agents[1]= new DefectAgent();
        agents[2]= new TitForTAtAgent();
        agents[3]= new TitEveryOtherTatAgent();
        agents[4]= new MixedStrategy();
        agents[5]= new MoveProbEqualOpponentsMoveProb();
        playTournament(agents,10);
        playTournament(agents,20);
        playTournament(agents,30);

    }

    private static double[] playMatches(Agent a1, Agent a2, int rounds){
        ArrayList<Agent.Action> a1Moves = new ArrayList<Agent.Action>();
        ArrayList<Agent.Action> a2Moves = new ArrayList<Agent.Action>();

        int a1Payoff = 0;
        int a2Payoff = 0;

        for (int i=0; i<rounds; i++){
            Agent.Action a1Move = a1.dilemma(a2Moves);
            Agent.Action a2Move = a2.dilemma(a1Moves);
            if (a1Move.equals(Agent.Action.DEFECT)){
                if (a2Move.equals(Agent.Action.DEFECT)){
                    a1Payoff += 2;
                    a2Payoff += 2;}
                else a1Payoff += 5;}
            else {
                if (a2Move.equals(Agent.Action.DEFECT)) a2Payoff += 5;
                else{
                    a1Payoff += 3;
                    a2Payoff += 3;}}
            a1Moves.add(a1Move);
            a2Moves.add(a2Move);
        }
        double[] scores = {a1Payoff/(double)rounds,a2Payoff/(double)rounds};
        return scores;
    }

    private static void playTournament(Agent[] agents, int rounds){
        double[] totalScores = new double[agents.length];
        double[] F_SCORE = new double[agents.length];

        for (int i=0; i<agents.length; i++){
            for (int k=0; k<agents.length; k++){
                if (!agents[i].equals(agents[k])){
                    double[] tempScores = playMatches(agents[i],agents[k],20);
                    totalScores[i] += tempScores[0];
                    totalScores[k] += tempScores[1];
                }
            }
        }
        for (int i=0; i<agents.length; i++){
            F_SCORE[i] = totalScores[i]/(double)6;
            System.out.println("F-SCORE of agent#"+(i+1)+": "+F_SCORE[i]+" after "+rounds+" rounds");
        }

    }
}
