package montacargas;

import agent.Action;

public class ActionLeft extends Action<MontaCargasState>{

    public ActionLeft(){
        super(1);
    }

    public void execute(MontaCargasState state){
        state.moveLeft();
        state.setAction(this);
    }

    public boolean isValid(MontaCargasState state){
        return state.canMoveLeft();
    }
}
