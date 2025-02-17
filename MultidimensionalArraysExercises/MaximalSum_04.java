package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = arr[0];
        int cols = arr[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s++"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxSum = Integer.MIN_VALUE;

        int bestStartingRow = 0;
        int bestStartingCol = 0;
        int sum = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];


                if(sum > maxSum) {
                    maxSum = sum;
                    bestStartingRow = i;
                    bestStartingCol = j;
                }
            }
        }
        System.out.printf("Sum = %d%n",maxSum);

        for (int row = bestStartingRow; row < bestStartingRow + 3; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
