package montacargas.pecas;

import montacargas.ActionDown;
import montacargas.ActionUp;

public class Peca5 extends Peca {

    public Peca5(int i, int j) {
        super(i, j);
        tamnho = 2;
        
        actions.add(new ActionUp(this));
        actions.add(new ActionDown(this));
    }
}