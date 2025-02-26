package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BombHasBeenPlanted_02 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sizeElements = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toList();
        int n = sizeElements.get(0);
        int m = sizeElements.get(1);

        char[][] matrix = fillMatrix(n, m, scanner);

        int seconds = 16;

        int row = getRow(matrix, 'C');
        int col = getRowCol(matrix, 'C');

        playBombHasBeenPlanted(scanner, matrix, row, col, seconds);

        printBombHasBeenPlanted(matrix);
    }

    private static char[][] fillMatrix(int n, int m, Scanner scanner) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }
        return matrix;
    }

    private static int getRow(char[][] matrix, char symbol) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == symbol) {
                    row = i;
                }
            }
        }
        return row;
    }

    private static int getRowCol(char[][] matrix, char symbol) {
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == symbol) {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playBombHasBeenPlanted(Scanner scanner, char[][] matrix, int row, int col, int seconds) {
        boolean isDead = false;
        boolean isWin = false;
        label:
        while (seconds > 0) {
            seconds--;
            String command = scanner.nextLine();
            int oldRow = row;
            int oldCol = col;
            switch (command) {
                case "up" -> row--;
                case "down" -> row++;
                case "left" -> col--;
                case "right" -> col++;
                case "defuse" -> {
                    char position = matrix[row][col];
                    if (position == 'B') {
                        seconds -= 3;
                        if (seconds >= 0) {
                            matrix[row][col] = 'D';
                            isWin = true;
                        }
                        break label;
                    } else {
                        seconds--;
                    }
                }
            }
            if (row < 0 || row > matrix[0].length - 1 || col < 0 || col > matrix[0].length - 1) {
                row = oldRow;
                col = oldCol;
            }
            char position = matrix[row][col];
            if (position == 'T') {
                matrix[row][col] = '*';
                isDead = true;
                break;
            }
        }

        if (isDead) {
            System.out.printf("Terrorists win!%n");
        } else {
            if (isWin) {
                System.out.printf("Counter-terrorist wins!%n");
                System.out.printf("Bomb has been defused: %d second/s remaining.%n", seconds);
            } else {
                if (seconds < 0) {
                    matrix[row][col] = 'X';
                }
                System.out.printf("Terrorists win!%n");
                System.out.printf("Bomb was not defused successfully!%n");
                System.out.printf("Time needed: %d second/s.%n", Math.abs(seconds));
            }
        }
    }

    private static void printBombHasBeenPlanted(char[][] matrix) {
        for (char[] chars : matrix) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                stringBuilder.append(aChar);
            }
            System.out.printf("%s%n", stringBuilder);
        }

    }
}
