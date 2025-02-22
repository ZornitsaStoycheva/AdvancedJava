package SetsAndMapsAdvancedLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> largestNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int length = largestNumbers.size();

        for (int i = 0; i < length; i++) {
            if (i == 3) {
                break;
            }

            System.out.printf(largestNumbers.get(i) + " ");
        }
    }
}
