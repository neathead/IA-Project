/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montacargas.heuristics;

import agent.Heuristic;
import montacargas.MontaCargasProblem;
import montacargas.MontaCargasState;

/**
 *
 * @author luis
 */
public class HeuristicCarDistance extends Heuristic<MontaCargasProblem, MontaCargasState>{

    public double compute(MontaCargasState state){
        return state.computeCarDistance(); 
    }
    
    @Override
    public String toString(){
        return "Car distance to the door position";
    }
}