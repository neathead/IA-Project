package montacargas;

import montacargas.heuristics.HeuristicTilesInFrontOfCar;
import montacargas.heuristics.HeuristicCarDistance;
import agent.Agent;
import gui.Properties;
import java.io.File;
import java.io.IOException;

public class MontaCargasAgent extends Agent<MontaCargasState>{
    static final int CAR = 1;
    static final int DOOR = 10;
    protected MontaCargasState initialEnvironment;    
    
    public MontaCargasAgent(MontaCargasState enviroment) {
        super(enviroment);
        initialEnvironment = (MontaCargasState) enviroment.clone();
        heuristics.add(new HeuristicTilesInFrontOfCar());
        heuristics.add(new HeuristicCarDistance());
        heuristic = heuristics.get(0); 
    }
            
    public MontaCargasState resetEnvironment(){
        environment = (MontaCargasState) initialEnvironment.clone();
        return environment;
    }
                 
    public MontaCargasState readInitialStateFromFile(File file) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(file);

        int tamanho = scanner.nextInt();
        int[][] matrix = new int [tamanho][tamanho];
        int doorY = tamanho/2;
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == CAR) {
                    doorY = i;
                }
            }
            scanner.nextLine();
        }
        matrix[doorY][tamanho-1] = DOOR;
        initialEnvironment = new MontaCargasState(matrix);
        resetEnvironment();
        return environment;
    }
}
