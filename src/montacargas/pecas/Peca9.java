package montacargas.pecas;

import montacargas.ActionDown;
import montacargas.ActionUp;

public class Peca9 extends Peca {

    public Peca9(int i, int j) {
        super(i, j);
        tamnho = 4;
        
        actions.add(new ActionUp(this));
        actions.add(new ActionDown(this));
    }
}