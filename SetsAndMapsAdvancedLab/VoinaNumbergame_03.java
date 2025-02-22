package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumbergame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;

        while (round-- > 0) {

            int firstNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNumber);

            int secondNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayerCards.add(firstNumber);
                firstPlayerCards.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayerCards.add(firstNumber);
                secondPlayerCards.add(secondNumber);
            }

            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
