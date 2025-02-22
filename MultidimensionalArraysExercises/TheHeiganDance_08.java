package MultidimensionalArraysExercises;

import java.util.Scanner;

public class TheHeiganDance_08 {

    static int positionPlayerRow = 7;
    static int positionPlayerCol = 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damagePlayer = Double.parseDouble(scanner.nextLine());
        int playerPoint = 18500;
        int HeiganPoint = 3000000;

        int [][] matrix = new int[15][15];

        fillMatrix(matrix);

        int matrix1 = matrix[positionPlayerRow][positionPlayerCol];
        System.out.println(matrix1);

        while (playerPoint <= 0 || HeiganPoint <= 0) {

            matrix1 = 'p';

            String[] data = scanner.nextLine().split(" ");
            String spell = data[0];
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);


            if (spell.equals("Cloud")) {

                

            } else if (spell.equals("Eruption")) {

            }
        }
    }

    public static int[][] fillMatrix(int[][] matrix) {
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += counter;
                counter++;
            }
        }

        return matrix;
    }
}
