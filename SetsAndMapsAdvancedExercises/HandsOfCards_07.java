package SetsAndMapsAdvancedExercises;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Map<String, Set<String>> map = new LinkedHashMap<>();

        Map<String, Integer> winCards = new LinkedHashMap<>();

        String name = "";

        while (!inputLine.equals("JOKER")) {
            String[] input = inputLine.split(":\\s+");

            name = input[0];

            String[] cards = input[1].split(",\\s+");


            for (int i = 0; i < cards.length; i++) {

                String currentCard = cards[i];

                if (!map.containsKey(name)) {
                    map.put(name, new LinkedHashSet<>());
                    map.get(name).add(currentCard);
                } else {
                    map.get(name).add(currentCard);
                }
            }

            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {

            Set<String> value = entry.getValue();

            int power = 1;

            int types = 1;

            for (int i = value.size() - 1; i >= 0; i--) {

                String currentCard = value.iterator().next();
                value.remove(currentCard);

                if (currentCard.startsWith("2")) {
                    power = 2;
                } else if (currentCard.startsWith("3")) {
                    power = 3;
                } else if (currentCard.startsWith("4")) {
                    power = 4;
                } else if (currentCard.startsWith("5")) {
                    power = 5;
                } else if (currentCard.startsWith("6")) {
                    power = 6;
                } else if (currentCard.startsWith("7")) {
                    power = 7;
                } else if (currentCard.startsWith("8")) {
                    power = 8;
                } else if (currentCard.startsWith("9")) {
                    power = 9;
                } else if (currentCard.startsWith("10")) {
                    power = 10;
                } else if (currentCard.startsWith("J")) {
                    power = 11;
                } else if (currentCard.startsWith("Q")) {
                    power = 12;
                } else if (currentCard.startsWith("K")) {
                    power = 13;
                } else if (currentCard.startsWith("A")) {
                    power = 14;
                }

                if (currentCard.endsWith("S")) {
                    types = 4;
                } else if (currentCard.endsWith("H")) {
                    types = 3;
                } else if (currentCard.endsWith("D")) {
                    types = 2;
                } else if (currentCard.endsWith("C")) {
                    types = 1;
                }

                int sum = power * types;

                if (!winCards.containsKey(entry.getKey())) {
                    winCards.put(entry.getKey(), sum);
                } else {
                    winCards.put(entry.getKey(), winCards.get(entry.getKey()) + sum);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : winCards.entrySet()) {

                System.out.printf("%s: %d%n",
                        entry.getKey(),
                        entry.getValue());
            }
        }
    }

