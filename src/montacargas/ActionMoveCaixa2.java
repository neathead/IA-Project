package montacargas;

import agent.Action;

public class ActionMoveCaixa2 extends Action<MontaCargasState>{

    public ActionMoveCaixa2(){
        super(1);
    }

    public void execute(MontaCargasState state){
        //state.moveCaixa2();
        state.setAction(this);
    }

    public boolean isValid(MontaCargasState state){
        return false; //state.canMoveCaixa2();
    }
}