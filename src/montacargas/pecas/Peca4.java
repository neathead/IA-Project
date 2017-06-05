package montacargas.pecas;

import montacargas.ActionLeft;
import montacargas.ActionRight;

public class Peca4 extends Peca {

    public Peca4(int i, int j) {
        super(i, j);
        tamanho = 2;
        
        actions.add(new ActionRight(this));
        actions.add(new ActionLeft(this));
    }
    
        @Override
    public Peca clone() {
        return new Peca4(linha, coluna);
    }
}