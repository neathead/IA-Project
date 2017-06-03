package montacargas.pecas;

import agent.Action;
import java.util.LinkedList;
import java.util.List;

public abstract class Peca implements Cloneable {
    protected int linha, coluna;
    protected int tamnho;
    protected LinkedList<Action> actions = new LinkedList<Action>();

    public Peca(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setLinha(int linha) {
        this.linha = linha;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peca other = (Peca) obj;
        if (this.linha != other.linha) {
            return false;
        }
        if (this.coluna != other.coluna) {
            return false;
        }
        return true;
    }
    
    @Override
    public abstract Peca clone();
}
