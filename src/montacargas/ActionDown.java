package montacargas;

import montacargas.pecas.Peca;
import agent.Action;

public class ActionDown extends Action<MontaCargasState>{

    public ActionDown(Peca peca){
        super(1, peca);
    }

    public void execute(MontaCargasState state){
        state.moveDown();
        state.setAction(this);
    }

    public boolean isValid(MontaCargasState state){
        return state.canMoveDown();
    }
}