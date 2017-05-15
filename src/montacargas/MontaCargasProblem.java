package montacargas;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MontaCargasProblem extends Problem<MontaCargasState> {
    private MontaCargasState goalState;
    
    public MontaCargasProblem(MontaCargasState initalState) {
        super(initalState, new ArrayList<Action>());
        //TODO: actions
        //actions.add(new ActionUp());
        //actions.add(new ActionRight());
        //actions.add(new ActionLeft());
        //actions.add(new ActionDown());
        
        this.goalState = new MontaCargasState(MontaCargasState.goalMatrix);
    }

    public List<MontaCargasState> executeActions(MontaCargasState state) {
        List<MontaCargasState> successors = new LinkedList<MontaCargasState>();
        for (Action a : actions) {
            if (a.isValid(state)) {
                MontaCargasState successor = (MontaCargasState) state.clone();
                a.execute(successor);
                successors.add(successor);
            }
        }
        return successors;
    }

    public boolean isGoal(MontaCargasState state) {
        return state.equals(goalState);
    }
        
    public MontaCargasState getGoalState() {
        return goalState;
    }

    @Override
    public double computePathCost(List<Action> path) {
        return path.size();
    }
}
