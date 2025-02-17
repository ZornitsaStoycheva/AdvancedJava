package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = arr[0];
        int col = arr[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < matrix.length ; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int minValue= Integer.MIN_VALUE;

        int[][] maxMatrix2x2 = new int[2][2];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {

                int sum = matrix[i][j] + matrix[i + 1][j]
                        + matrix[i + 1][j + 1] + matrix[i][j + 1];
                if(sum > minValue) {
                    minValue = sum;

                    maxMatrix2x2[0][0] = matrix[i][j];
                    maxMatrix2x2[0][1] = matrix[i][j + 1];
                    maxMatrix2x2[1][0] = matrix[i + 1][j];
                    maxMatrix2x2[1][1] = matrix[i + 1][j + 1];
                }
            }
        }
        for (int[] ints : maxMatrix2x2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.print(minValue);
    }
}
