package montacargas.pecas;

import montacargas.ActionLeft;
import montacargas.ActionRight;

public class Peca6 extends Peca {

    public Peca6(int i, int j) {
        super(i, j);
        tamnho = 3;
        
        actions.add(new ActionRight(this));
        actions.add(new ActionLeft(this));
    }
}