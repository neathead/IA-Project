package montacargas.pecas;

import montacargas.ActionLeft;
import montacargas.ActionRight;

public class Peca8 extends Peca {

    public Peca8(int i, int j) {
        super(i, j);
        tamnho = 4;
        
        actions.add(new ActionRight(this));
        actions.add(new ActionLeft(this));
    }
}