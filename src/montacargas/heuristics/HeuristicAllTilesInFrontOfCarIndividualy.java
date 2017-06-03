package montacargas.heuristics;

import agent.Heuristic;
import montacargas.MontaCargasProblem;
import montacargas.MontaCargasState;

public class HeuristicAllTilesInFrontOfCarIndividualy extends Heuristic<MontaCargasProblem, MontaCargasState>{

    public double compute(MontaCargasState state){
        return state.computeAllTilesInFrontOfCarIndividualy(); 
    }
    
    @Override
    public String toString(){
        return "All Tiles In Front Of Car Individualy";
    }
}