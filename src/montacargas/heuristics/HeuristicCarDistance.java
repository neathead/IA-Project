package montacargas.heuristics;

import agent.Heuristic;
import montacargas.MontaCargasProblem;
import montacargas.MontaCargasState;

public class HeuristicCarDistance extends Heuristic<MontaCargasProblem, MontaCargasState>{

    public double compute(MontaCargasState state){
        return state.computeCarDistance(); 
    }
    
    @Override
    public String toString(){
        return "Car distance to the door position";
    }
}