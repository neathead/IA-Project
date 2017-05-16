package montacargas;

import montacargas.pecas.Peca;
import agent.Action;

public class ActionUp extends Action<MontaCargasState>{

    public ActionUp(Peca peca){
        super(1, peca);
    }

    public void execute(MontaCargasState state){
        state.moveUp();
        state.setAction(this);
    }

    public boolean isValid(MontaCargasState state){
        return state.canMoveUp();
    }
}