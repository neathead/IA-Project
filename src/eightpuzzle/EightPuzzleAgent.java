package eightpuzzle;

import agent.Agent;
import java.io.File;
import java.io.IOException;

public class EightPuzzleAgent extends Agent<EightPuzzleState>{
    
    protected EightPuzzleState initialEnvironment;    
    
    public EightPuzzleAgent(EightPuzzleState environemt) {
        super(environemt);
        initialEnvironment = (EightPuzzleState) environemt.clone();
        heuristics.add(new HeuristicTileDistance());
        heuristics.add(new HeuristicTilesOutOfPlace());
        heuristic = heuristics.get(0);
    }
            
    public EightPuzzleState resetEnvironment(){
        environment = (EightPuzzleState) initialEnvironment.clone();
        return environment;
    }
                 
    public EightPuzzleState readInitialStateFromFile(File file) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(file);

        int tamanho = scanner.nextInt();
        int linha = 3; 
        scanner.nextLine();
        
        int[][] matrix = new int [tamanho][tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrix[i][j] = scanner.nextInt();
                //guardar a posicao do carro
                if (matrix[i][j] == 1) {
                    linha = i;
                }
            }
            scanner.nextLine();
        }
        
        //Colocar a porta sempre á frente do carro (na mesma linha) na ultima coluna
        matrix[linha][tamanho-1] = 10;
        
        initialEnvironment = new EightPuzzleState(matrix);
        resetEnvironment();
        return environment;
    }
}
