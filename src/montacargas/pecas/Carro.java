package montacargas.pecas;

import montacargas.ActionLeft;
import montacargas.ActionRight;

public class Carro extends Peca {

    public Carro(int i, int j) {
        super(i, j);
        tamnho = 1;
        
        actions.add(new ActionRight(this));
        actions.add(new ActionLeft(this));
    }
}