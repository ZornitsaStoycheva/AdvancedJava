package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class BombHasBeenPlanted_02 {

    public static int startRow;
    public static int startCol;
    public static boolean isBomb = false;
    public static boolean isFoundT = false;
    public static int time = 16;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = arr[0];
        int col = arr[1];

        char[][] matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            String matrixToCharArray = scanner.nextLine();
            matrix[i] = matrixToCharArray.toCharArray();
        }

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 'C') {
                    startRow = rows;
                    startCol = cols;
                }
            }
        }

        String input = scanner.nextLine();


        while (time > 0 && !isBomb && !isFoundT) {

            String command = null;
            switch (input) {
                case "up":
                    command = scanner.nextLine();
                    moveCounterStroke(matrix, -1, 0, command);
                    break;
                case "down":
                    command = scanner.nextLine();
                    moveCounterStroke(matrix, +1, 0, command);
                    break;
                case "right":
                    command = scanner.nextLine();
                    moveCounterStroke(matrix, 0, +1, command);
                    break;
                case "left":
                    command = scanner.nextLine();
                    moveCounterStroke(matrix, 0, -1, command);
                    break;
            }

            input = command;

        }
        printMatrix(matrix);

    }

    private static void moveCounterStroke (char[][] matrix, int row, int col, String command) {
        int nextRow = startRow + row;
        int nextCol = startCol + col;

        if (isValid(matrix, nextRow, nextCol)) {

            if (matrix[nextRow][nextCol] == '*') {
                matrix[startRow][startCol] = '*';
                matrix[nextRow][nextCol] = 'C';
                startRow = nextRow;
                startCol = nextCol;
                time --;
            } else if (matrix[nextRow][nextCol] == 'T') {
                matrix[startRow][startCol] = '*';
                matrix[nextRow][nextCol] = 'C';
                time --;
                isFoundT = true;
            } else if (matrix[nextRow][nextCol] == 'B') {

                if (command.equals("defuse")) {
                    time -= 4;
                    matrix[nextRow][nextCol] = 'D';
                    isBomb = true;
                    matrix[startRow][startCol] = 'C';
                } else {
                    time -= 2;
                    isBomb = true;
                }


                if (time <= 0) {
                    matrix[nextRow][nextCol] = 'X';
                }
                //matrix[startRow][startCol] = 'C';
            }
        }
    }

    private static boolean isValid(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] charts : matrix) {
            for (char anInt : charts) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
