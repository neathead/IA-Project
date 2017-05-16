/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montacargas;

import agent.Heuristic;

public class HeuristicTilesOutOfPlace extends Heuristic<MontaCargasProblem, MontaCargasState> {

    public double compute(MontaCargasState state) {
        return 0; //STORA STORA state.computeTilesOffPlace();
    }

    @Override
    public String toString() {
        return "Tiles out of place";
    }
}
