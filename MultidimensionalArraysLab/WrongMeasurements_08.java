package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = arr[0];
        int col = arr[1];

        int current = matrix[row][col];

        List<int[]> value = new ArrayList<>();

        boolean isEqual = false;
        int firstValue = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {

                if (current == matrix[rows][cols]) {

                    if (isValid(matrix, rows, cols + 1) && matrix[rows][cols + 1] != current) {
                        firstValue += matrix[rows][cols + 1];
                    }

                    if (isValid(matrix, rows, cols - 1) && matrix[rows][cols - 1] != current) {
                        firstValue += matrix[rows][cols - 1];
                    }

                    if (isValid(matrix, rows + 1, cols) && matrix[rows + 1][cols] != current) {
                        firstValue += matrix[rows + 1][cols];
                    }

                    if (isValid(matrix, rows - 1, cols) && matrix[rows - 1][cols] != current) {
                        firstValue += matrix[rows - 1][cols];
                    }

                    value.add(new int[] { rows, cols, firstValue});

                    firstValue = 0;
                }
            }
        }

        for (int[] correctValue : value) {
            int r = correctValue[0];
            int c = correctValue[1];
            matrix[r][c] = correctValue[2];
        }
        printMatrix(matrix);
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
