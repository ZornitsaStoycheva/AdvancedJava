package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> periodicTable = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            for (int j = 0; j < data.length; j++) {
                String chemicalElement = data[j];

                if (!periodicTable.contains(chemicalElement)) {
                    periodicTable.add(chemicalElement);
                }
            }
        }

        periodicTable.forEach(x -> System.out.print(x + " "));
    }
}
