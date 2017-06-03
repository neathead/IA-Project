package montacargas.pecas;

import montacargas.ActionDown;
import montacargas.ActionUp;

public class Peca3 extends Peca {

    public Peca3(int i, int j) {
        super(i, j);
        tamnho = 1;
        
        actions.add(new ActionUp(this));
        actions.add(new ActionDown(this));
    }
    
        @Override
    public Peca clone() {
        return new Peca3(linha, coluna);
    }
}