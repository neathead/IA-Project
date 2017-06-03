package montacargas.heuristics;

import agent.Heuristic;
import montacargas.MontaCargasProblem;
import montacargas.MontaCargasState;

public class HeuristicCarDistancePlusTilesInFront extends Heuristic<MontaCargasProblem, MontaCargasState> {

    public double compute(MontaCargasState state) {
        return state.computeCarDistance() + state.computeTilesInFrontOfCar();
    }

    @Override
    public String toString() {
        return "Distance to Door and Tiles in Front of Car";
    }
}