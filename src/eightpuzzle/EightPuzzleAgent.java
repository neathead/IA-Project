package eightpuzzle;

import agent.Agent;
import agent.Problem;
import gui.Properties;
import java.io.File;
import java.io.IOException;

public class EightPuzzleAgent extends Agent<EightPuzzleState> {

    public static final int CAR = 1;
    public static final int DOOR = 10;
    protected EightPuzzleState initialEnvironment;

    public EightPuzzleAgent(EightPuzzleState environemt) {
        super(environemt);
        initialEnvironment = (EightPuzzleState) environemt.clone();
        heuristics.add(new HeuristicTileDistance());
        heuristics.add(new HeuristicTilesOutOfPlace());
        heuristic = heuristics.get(0);
    }

    public EightPuzzleState resetEnvironment() {
        environment = (EightPuzzleState) initialEnvironment.clone();
        return environment;
    }

    public EightPuzzleState readInitialStateFromFile(File file) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(file);

        int tamanho = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[tamanho][tamanho];
        int linha = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == CAR) {
                    linha = i;
                }
            }
            scanner.nextLine();
        }

        matrix[linha][tamanho - 1] = DOOR;
        initialEnvironment = new EightPuzzleState(matrix);
        resetEnvironment();
        return environment;
    }
}
