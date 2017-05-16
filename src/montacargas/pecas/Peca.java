package montacargas.pecas;

import agent.Action;
import java.util.LinkedList;
import java.util.List;

public class Peca {
    private int linha, coluna;
    protected int tamnho;
    protected LinkedList<Action> actions;

    public Peca(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getTamnho() {
        return tamnho;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
    
    public LinkedList<Action> getActions() {
        return actions;
    }
}
