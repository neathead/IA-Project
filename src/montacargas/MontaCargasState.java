package montacargas;

import montacargas.pecas.*;
import agent.Action;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import utils.Posicao;

public class MontaCargasState extends State implements Cloneable {
    private int[][] matrix;    
    private int columnCarro;
    private LinkedList<Peca> pecas = new LinkedList<Peca>();

    public MontaCargasState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];
        LinkedList<Posicao> skip = new LinkedList<Posicao>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (skip.contains(new Posicao(i, j))) {
                    continue;
                }
                switch(this.matrix[i][j]) {
                    case 1:
                        pecas.add(new Carro(i,j));
                        columnCarro=j;
                        break;
                    case 2:
                        pecas.add(new Peca2(i, j)); break;
                    case 3:
                        pecas.add(new Peca3(i, j)); break;
                    case 4:
                        pecas.add(new Peca4(i, j)); 
                        j++;
                        break;
                    case 5:
                        pecas.add(new Peca5(i, j));
                        skip.add(new Posicao(i+1, j));
                        break;
                    case 6:
                        pecas.add(new Peca6(i, j));
                        j+=2;
                        break;
                    case 7:
                        pecas.add(new Peca7(i, j));
                        skip.add(new Posicao(i+1, j));
                        skip.add(new Posicao(i+2, j));
                        break;
                    case 8:
                        pecas.add(new Peca8(i, j));
                        j+=3;
                        break;
                    case 9:
                        pecas.add(new Peca9(i, j)); 
                        skip.add(new Posicao(i+1, j));
                        skip.add(new Posicao(i+2, j));
                        skip.add(new Posicao(i+3, j));
                        break;
                }
            }
        }
        
        System.out.println(pecas.size());
    }
    
    public boolean canMoveLeft(Peca peca) { //Horizontais
        if (peca.getColuna()-1 >= 0) {
            if (matrix[peca.getLinha()][peca.getColuna()-1] == 0) {
                return true;
            }
        }
        return false;
    }
        
    public boolean canMoveRight(Peca peca) { //Horizontais
        if (peca.getColuna()+peca.getTamnho() < matrix.length) {
            if (matrix[peca.getLinha()][peca.getColuna()+peca.getTamnho()] == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canMoveUp(Peca peca) { //Verticais
        if (peca.getLinha()-1 >= 0) {
            if (matrix[peca.getLinha()-1][peca.getColuna()] == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canMoveDown(Peca peca) { //Verticais
        if (peca.getLinha()+peca.getTamnho() < matrix.length) {
            if (matrix[peca.getLinha()+peca.getTamnho()][peca.getColuna()] == 0) {
                return true;
            }
        }
        return false;
    }

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class MontaCargasProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveLeft(Peca peca) { //Horizontais
        if (peca instanceof Carro) {
            matrix[peca.getLinha()][peca.getColuna()-1] = 1;
            matrix[peca.getLinha()][peca.getColuna()] = 0;
            columnCarro--;
        }
        if (peca instanceof Peca2) {
            matrix[peca.getLinha()][peca.getColuna()-1] = 2;
            matrix[peca.getLinha()][peca.getColuna()] = 0;
        }
            
        /*
        matrix[lineBlank][columnBlank] = matrix[--lineBlank][columnBlank];
        matrix[lineBlank][columnBlank] = 0;
        */
    }
        
    public void moveRight(Peca peca) { //Horizontais
        if (peca instanceof Carro) {
            matrix[peca.getLinha()][peca.getColuna()+1] = 1;
            matrix[peca.getLinha()][peca.getColuna()] = 0;
            columnCarro++;
        }
        if (peca instanceof Peca2) {
            matrix[peca.getLinha()][peca.getColuna()+1] = 2;
            matrix[peca.getLinha()][peca.getColuna()] = 0;
        }
    }
    
    public void moveUp(Peca peca) { //Verticais
        if (peca instanceof Peca3) {
            matrix[peca.getLinha()+1][peca.getColuna()] = 3;
            matrix[peca.getLinha()][peca.getColuna()] = 0;
        }
    }

    public void moveDown(Peca peca) { //Verticais
        if (peca instanceof Peca3) {
            matrix[peca.getLinha()-1][peca.getColuna()] = 3;
            matrix[peca.getLinha()][peca.getColuna()] = 0;
        }
    }
    
    public int getNumLines() {
        return matrix.length;
    }

    public int getNumColumns() {
        return matrix[0].length;
    }
    
    LinkedList<Action> getActions() {
        LinkedList<Action> actions = new LinkedList<Action>();
        for (Peca peca : pecas) {
            actions.addAll(peca.getActions());
        }
        return actions;
    }

    public int getTileValue(int line, int column) {
        if (!isValidPosition(line, column)) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        return matrix[line][column];
    }

    public boolean isValidPosition(int line, int column) {
        return line >= 0 && line < matrix.length && column >= 0 && column < matrix[0].length;
    }

    //Listeners
    private transient ArrayList<MontaCargasListener> listeners = new ArrayList<MontaCargasListener>(3);

    public synchronized void removeListener(MontaCargasListener l) {
        if (listeners != null && listeners.contains(l)) {
            listeners.remove(l);
        }
    }

    public synchronized void addListener(MontaCargasListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public void firePuzzleChanged(MontaCargasEvent pe) {
        for (MontaCargasListener listener : listeners) {
            listener.puzzleChanged(null);
        }
    }
    
    @Override
    public void executeAction(Action action) {
        action.execute(this);
        firePuzzleChanged(null);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }
    
    @Override
    public Object clone() {
        return new MontaCargasState(matrix);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MontaCargasState)) {
            return false;
        }

        MontaCargasState o = (MontaCargasState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }
    
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }
/* STORA STORA
    double computeTilesDistance() {
        double h = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    h +=Math.abs(i-linesfinalMatrix[matrix[i][j]]) +
                        Math.abs(j-colsfinalMatrix[matrix[i][j]]);
                }
            }
        }
        
        return h;
    }

    double computeTilesOffPlace() {
        double h = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != goalMatrix[i][j]) {
                    h++;
                }
            }
        }
        
        return h;
    }
*/
    /**
     * @return the columnCarro
     */
    public int getColumnCarro() {
        return columnCarro;
    }

    /**
     * @param columnCarro the columnCarro to set
     */
    public void setColumnCarro(int columnCarro) {
        this.columnCarro = columnCarro;
    }
}
