package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[row][col];
        String[][] secondMatrix = new String[row][col];

        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if(!(firstMatrix[i][j].equals(secondMatrix[i][j]))) {
                    String replace = firstMatrix[i][j].replace(firstMatrix[i][j], "*");
                    firstMatrix[i][j] = replace;
                }
            }
        }
        for (String[] matrix : firstMatrix) {
            for (String s : matrix) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
