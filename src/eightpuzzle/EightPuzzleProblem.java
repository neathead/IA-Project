package eightpuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EightPuzzleProblem extends Problem<EightPuzzleState> {
<<<<<<< HEAD
<<<<<<< HEAD
    private EightPuzzleState goalState;
    
    public EightPuzzleProblem(EightPuzzleState initalState) {
        super(initalState, new ArrayList<Action>());
=======



    public EightPuzzleProblem(EightPuzzleState initialState) {
        super(initialState, new ArrayList<Action>());
>>>>>>> refs/remotes/origin/mayelson
=======


    private EightPuzzleState goalState;
    
    public EightPuzzleProblem(EightPuzzleState initalState) {
        super(initalState, new ArrayList<Action>());

>>>>>>> origin/master
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());

       
    }
//alterar este metodo
    @Override
    public List<EightPuzzleState> executeActions(EightPuzzleState state) {
        List<EightPuzzleState> successors = new LinkedList<EightPuzzleState>();
        for (Action a : actions) {
            if (a.isValid(state)) {
                EightPuzzleState successor = (EightPuzzleState) state.clone();
                a.execute(successor);
                successors.add(successor);
            }
        }
        return successors;
    }


    //alterar este metodo
    @Override
    public boolean isGoal(EightPuzzleState state) {
        
        return false;

    }

    @Override
    public double computePathCost(List<Action> path) {
        return path.size();
    }

}
