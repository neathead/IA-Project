package montacargas.pecas;

import montacargas.ActionLeft;
import montacargas.ActionRight;

public class Peca6 extends Peca {

    public Peca6(int i, int j) {
        super(i, j);
        tamanho = 3;
        
        actions.add(new ActionRight(this));
        actions.add(new ActionLeft(this));
    }
    
        @Override
    public Peca clone() {
        return new Peca6(linha, coluna);
    }
}