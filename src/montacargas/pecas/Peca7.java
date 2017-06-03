package montacargas.pecas;

import montacargas.ActionDown;
import montacargas.ActionUp;

public class Peca7 extends Peca {

    public Peca7(int i, int j) {
        super(i, j);
        tamnho = 3;
        
        actions.add(new ActionUp(this));
        actions.add(new ActionDown(this));
    }
    
        @Override
    public Peca clone() {
        return new Peca7(linha, coluna);
    }
}