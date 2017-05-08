package agent;

import java.util.List;

public abstract class Problem<S extends State> {

    protected S initialState;
    protected List<Action> actions;
    protected Heuristic heuristic;

    public Problem(S initialState, List<Action> action) {
        this.initialState = initialState;
        this.actions = action;
      
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    public abstract List<S> executeActions(S state);

    public abstract boolean isGoal(S state);

    public double computePathCost(List<Action> path) {
        double cost = 0;

        for (Action a : path) {
            cost += a.getCost();
        }

        return cost;
    }

    public S getInitialState() {
        return initialState;
    }
    
}
