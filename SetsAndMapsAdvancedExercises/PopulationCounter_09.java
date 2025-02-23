package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();
        Map<String, Integer> count = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("report")) {

            String[] data = input.split("\\|");

            String city = data[0];
            String country = data[1];
            int people = Integer.parseInt(data[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countries.get(country).put(city, people);
            } else {
                Map<String, Integer> cities = countries.get(country);
                if (!cities.containsKey(city)) {
                    cities.put(city, people);
                } else {
                    cities.put(city, cities.get(city) + people);
                }
            }

            if (!count.containsKey(country)) {
                count.put(country, people);
            } else {
                count.put(country, count.get(country) + people);
            }

            input = scanner.nextLine();
        }

        countries.entrySet().stream()
                .sorted((c1,c2)-> count.get(c2.getKey()).compareTo(count.get(c1.getKey())))
                .forEach(country ->{
                    System.out.format("%s (total population: %d)\n",country.getKey(),count.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                                System.out.format("=>%s: %d\n", city.getKey(),city.getValue());
                            });
                });
    }
}
