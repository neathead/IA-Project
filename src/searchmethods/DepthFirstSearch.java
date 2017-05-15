package searchmethods;

import agent.Problem;
import agent.Solution;
import agent.State;
import java.util.List;
import utils.NodeLinkedList;

public class DepthFirstSearch extends GraphSearch<NodeLinkedList> {

    public DepthFirstSearch() {
        frontier = new NodeLinkedList();
    }

    //Graph Search without explored list
    @Override
    protected Solution graphSearch(Problem problem) {
        frontier.clear();
        explored.clear();
        frontier.add(new Node (problem.getInitalState()));
        while (!frontier.isEmpty()) {
            Node n = frontier.poll();
            if (problem.isGoal(n.getState())) {
                return new Solution(problem, n);
            }
            explored.add(n.getState());
            List<State> sucessors = problem.executeActions(n.getState());
            addSuccessorsToFrontier(sucessors, n);
            computeStatistics(sucessors.size());
        }
        return null;
    }

    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        //for (State s : successors) {
            for (int i = successors.size()-1; i >=0; i--) {
                State s = successors.get(i);
                if (!frontier.containsState(s)) {
                    Node n = new Node(s, parent);
                    if (!n.isCycle()) {
                        frontier.addFirst(n);
                    }
                }
            }
        //}
        
    }

    @Override
    public String toString() {
        return "Depth first search";
    }
}
