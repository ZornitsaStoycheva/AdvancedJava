package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!map.containsKey(symbol)) {
                map.put(symbol, 1);
            } else {
                map.put(symbol, map.get(symbol) + 1);
            }
        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((x) ->
                System.out.printf("%c: %d time/s%n", x.getKey(), x.getValue()));

    }
}
