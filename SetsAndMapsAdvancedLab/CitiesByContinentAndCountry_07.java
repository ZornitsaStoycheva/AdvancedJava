package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if (!continents.containsKey(continent)) {
                continents.put(continent, new LinkedHashMap<>());
                continents.get(continent).put(country, new ArrayList<>());
                continents.get(continent).get(country).add(city);
            } else {

                Map<String, List<String>> stringListMap = continents.get(continent);
                if (!stringListMap.containsKey(country)) {
                    continents.get(continent).put(country, new ArrayList<>());
                    continents.get(continent).get(country).add(city);
                } else {
                    continents.get(continent).get(country).add(city);
                }


            }
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : continents.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (Map.Entry<String, List<String>> entryValue : entry.getValue().entrySet()) {
                System.out.printf("%s -> ",entryValue.getKey());

                String join = String.join(", ", entryValue.getValue());
                System.out.print(join);
                System.out.println();
            }

        }

    }
}
