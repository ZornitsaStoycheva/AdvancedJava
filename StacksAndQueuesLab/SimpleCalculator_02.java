package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> simpleCalculator = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0 ; i--) {
            simpleCalculator.push(input[i]);
        }
        while (simpleCalculator.size() > 1) {
            int first = Integer.parseInt(simpleCalculator.pop());
            String operation;
            operation = simpleCalculator.pop();
            int second = Integer.parseInt(simpleCalculator.pop());

            if(operation.equals("+")) {
                simpleCalculator.push(String.valueOf(first + second));
            } else if (operation.equals("-")) {
                simpleCalculator.push(String.valueOf(first - second));
            }
        }

        System.out.println(simpleCalculator.pop());

    }
}
