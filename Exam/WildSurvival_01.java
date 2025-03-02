package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class WildSurvival_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bees = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(bees::push);

        ArrayDeque<Integer> beeEaters = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(beeEaters::offer);
    }
}
