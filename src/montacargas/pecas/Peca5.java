package montacargas.pecas;

import montacargas.ActionDown;
import montacargas.ActionUp;

public class Peca5 extends Peca {

    public Peca5(int i, int j) {
        super(i, j);
        tamanho = 2;
        
        actions.add(new ActionUp(this));
        actions.add(new ActionDown(this));
    }
    
        @Override
    public Peca clone() {
        return new Peca5(linha, coluna);
    }
}