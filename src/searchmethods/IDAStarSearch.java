package searchmethods;

import agent.Problem;
import agent.Solution;
import agent.State;
import java.util.List;

public class IDAStarSearch extends InformedSearch {
    /*
     * Note that, on each iteration, the search is done in a depth first search way.    
     */
    
    private double limit;
    private double newLimit;    

    @Override
    public Solution search(Problem problem) {
        statistics.reset();
        this.heuristic = problem.getHeuristic();
        
        limit = heuristic.compute(problem.getInitalState());
        
        Solution solution;
        do {
            solution=graphSearch(problem);
        } while (solution == null );
        return solution;
    }

    @Override
    protected Solution graphSearch(Problem problem) {
        newLimit = Double.POSITIVE_INFINITY;
        frontier.clear();
        frontier.add(new Node (problem.getInitalState()));
        
        while (!frontier.isEmpty() && !stopped) {
            Node n = frontier.poll();
            if (problem.isGoal(n.getState())) {
                return new Solution(problem, n);
            }
            
            List<State> sucessors = problem.executeActions(n.getState());
            addSuccessorsToFrontier(sucessors, n);
            computeStatistics(sucessors.size());
        }
        limit=newLimit;
        return null;
    }

    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        for (State s : successors) {
            double g = parent.getG() + s.getAction().getCost();
            
            if (!frontier.containsState(s)) {
                double f = g+heuristic.compute(s);
                if (f <= limit) {
                    Node n = new Node(s, parent, g, f);
                    if (!n.isCycle()) {
                        frontier.add(n);
                    }
                } else {
                    newLimit = Math.min(newLimit, f);
                }
            } else if (frontier.getNode(s).getG() > g) {
                frontier.remove(s);
                frontier.add(new Node(s, parent, g, g+heuristic.compute(s)));
            }
        }
    }

    @Override
    public String toString() {
        return "IDA* Search";
    }
}
