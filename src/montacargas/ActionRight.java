package montacargas;

import montacargas.pecas.Peca;
import agent.Action;

public class ActionRight extends Action<MontaCargasState>{

    public ActionRight(Peca peca){
        super(1, peca);
    }

    public void execute(MontaCargasState state){
        state.moveRight();
        state.setAction(this);
    }

    public boolean isValid(MontaCargasState state){
        return state.canMoveRight();
    }
}