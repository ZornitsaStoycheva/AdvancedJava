package MultidimensionalArraysLab;

import java.util.Scanner;

public class FindTheRealQueen_07 {

    private static int row;
    private static int col;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String symbol = matrix[i][j];

                if(symbol.equals("q")) {
                    if(isFound(matrix, i, j)) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
    }
    private static boolean isFound(String[][] matrix, int row, int col) {
        for (int i = col + 1; i < matrix[row].length; i++) {
            if(matrix[row][i].equals("q")) {
                return false;
            }
        }

        for (int i = col - 1; i >= 0 ; i--) {
            if(matrix[row][i].equals("q")) {
                return false;
            }
        }

        for (int i = row + 1; i < matrix.length; i++) {
            if(matrix[i][col].equals("q")) {
                return false;
            }
        }

        for (int i = row - 1; i >= 0 ; i--) {
            if(matrix[i][col].equals("q")) {
                return false;
            }
        }

        row = 0;
        col = 0;
        for (int i = row + 1; i < matrix.length - 1; i++) {
            for (int j = col + 1; j < matrix[row].length - 1; j++) {
                row++;
                col++;
                if(matrix[i][i].equals("q")) {
                    return false;
                }
            }
        }

        row = 0;
        col = matrix.length - 1;
        for (int i = row + 1; i < matrix.length - 1; i++) {
            for (int j = col - 1; j >= 0 ; j--) {
                row ++;
                col --;
                if(matrix[i][i].equals("q")) {
                    return false;
                }
            }
        }

        row = matrix.length - 1;
        col = 0;
        for (int i = row - 1; i >= 0 ; i--) {
            for (int j = col + 1; j < matrix.length - 1; j++) {
                row--;
                col ++;
                if(matrix[i][i].equals("q")) {
                    return false;
                }
            }
        }

        row = matrix.length - 1;
        col = matrix.length - 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                row--;
                col--;
                if(matrix[i][i].equals("q")) {
                    return false;
                }
            }
        }
        return true;

    }
}
