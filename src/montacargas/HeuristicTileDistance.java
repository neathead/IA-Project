/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montacargas;

import agent.Heuristic;

/**
 *
 * @author luis
 */
public class HeuristicTileDistance extends Heuristic<MontaCargasProblem, MontaCargasState>{

    public double compute(MontaCargasState state){
        return 1; //STORA STORA state.computeTilesDistance(); 
    }
    
    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}