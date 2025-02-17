package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int rows = n;
        int cols = n;

        int[][] matrix = new int[rows][cols];
        int counter = 1;

        if(pattern.equals("A")) {
            FillMatrixPatternA(rows, cols, matrix, counter);
        } else {
            FillMatrixPatternB(rows, cols, matrix, counter);
        }
        PrintMatrix(matrix);
    }

    private static void PrintMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void FillMatrixPatternB(int rows, int cols, int[][] matrix, int counter) {
        for (int col = 0; col < cols; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static int FillMatrixPatternA(int rows, int cols, int[][] matrix, int counter) {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return counter;

    }
}
