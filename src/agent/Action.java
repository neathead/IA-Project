package agent;

import montacargas.pecas.Peca;


public abstract class Action <S extends State>{
    private double cost;
    protected Peca peca;

    public Peca getPeca() {
        return peca;
    }

    public Action(double cost, Peca peca){
        this.cost = cost;
        this.peca=peca;
    }

    public abstract void execute(S State);

    public abstract boolean isValid(S State);

    public double getCost(){
        return cost;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    
}