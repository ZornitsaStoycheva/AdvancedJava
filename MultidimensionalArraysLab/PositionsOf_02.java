package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = arr[0];
        int col = arr[1];

        int[][] matrix = new int[row][col];

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < matrix.length ; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int wantedDigit = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == wantedDigit) {
                    stringBuilder.append(i)
                            .append(" ")
                            .append(j)
                            .append(System.lineSeparator());
                }
            }
        }
        System.out.print(stringBuilder.isEmpty() ? "not found" :
                stringBuilder.toString());

    }
}
