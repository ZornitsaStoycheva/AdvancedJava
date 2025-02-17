package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s++"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int primaryDiagonalSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            primaryDiagonalSum += matrix[row][row];
        }

        int secondaryDiagonalSum = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0 ; row--, col ++) {
            secondaryDiagonalSum += matrix[row][col];
        }

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}
