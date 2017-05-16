package montacargas;

import montacargas.pecas.Peca;
import agent.Action;

public class ActionLeft extends Action<MontaCargasState>{

    public ActionLeft(Peca peca){
        super(1, peca);
    }

    public void execute(MontaCargasState state){
        state.moveLeft(peca);
        state.setAction(this);
    }

    public boolean isValid(MontaCargasState state){
        return state.canMoveLeft(peca);
    }
}
