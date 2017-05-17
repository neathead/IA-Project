package montacargas.pecas;

import montacargas.ActionLeft;
import montacargas.ActionRight;

public class Peca2 extends Peca {

    public Peca2(int i, int j) {
        super(i, j);
        tamnho = 1;
        
        actions.add(new ActionRight(this));
        actions.add(new ActionLeft(this));
    }
}