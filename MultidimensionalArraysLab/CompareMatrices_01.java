package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = arr[0];
        int col = arr[1];

        int[][] firstMatrix = new int[row][col];

        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        row = arr[0];
        col = arr[1];

        int[][] secondMatrix = new int[row][col];

        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean isEqual = firstMatrix.length == secondMatrix.length
                && getaBoolean(firstMatrix, secondMatrix);
        System.out.println(isEqual ? "equal" : "not equal");
    }

    private static boolean getaBoolean(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) {
                return false;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }
}
