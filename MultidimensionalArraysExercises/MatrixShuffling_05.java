package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        System.out.println();

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            String[] data = command.split("\\s+");

            if(data[0].equals("swap") && data.length == 5) {
                int rowFirstElement = Integer.parseInt(data[1]);
                int colFirstElement = Integer.parseInt(data[2]);
                int rowSecondElement = Integer.parseInt(data[3]);
                int colSecondElement = Integer.parseInt(data[4]);

                if(isValid(matrix,rowFirstElement, colFirstElement)
                        && isValid(matrix, rowSecondElement, colSecondElement)) {
                    String swapFirst = matrix[rowFirstElement][colFirstElement];
                    matrix[rowFirstElement][colFirstElement] = matrix[rowSecondElement][colSecondElement];
                    matrix[rowSecondElement][colSecondElement] = swapFirst;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }
    private static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
