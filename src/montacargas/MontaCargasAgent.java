/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montacargas;

import agent.Agent;

/**
 *
 * @author luis
 */
public class MontaCargasAgent extends Agent<MontaCargasState>{
    protected MontaCargasState initialEnvironment; 
    
    public MontaCargasAgent(MontaCargasState environment) {
        super(environment);
        initialEnvironment = (MontaCargasState) environment.clone();
    }
    
}
