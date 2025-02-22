package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> mapToArray = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            double digit = arr[i];

            if (!mapToArray.containsKey(digit)) {
                mapToArray.put(digit, 1);
            } else {
                mapToArray.put(digit, mapToArray.get(digit) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : mapToArray.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
