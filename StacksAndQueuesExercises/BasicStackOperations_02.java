package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s++");
        String[] numbers = scanner.nextLine().split("\\s++");

        int numberOfStack = Integer.parseInt(input[0]);
        int numbersOfPop = Integer.parseInt(input[1]);
        int searchNumber = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfStack; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numbersOfPop; i++) {
            stack.pop();
        }

        if(stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(searchNumber)) {
            System.out.println("true");
        } else {
            System.out.println(stack.stream().min((s, f) -> s.compareTo(f)).get());
        }
    }
}
