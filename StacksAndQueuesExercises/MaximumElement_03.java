package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] inputNumber = scanner.nextLine().split("\\s++");

            if(inputNumber[0].equals("1")) {
                stack.push(Integer.parseInt(inputNumber[1]));
            } else if (inputNumber[0].equals("2")) {
                stack.pop();
            } else if(inputNumber[0].equals("3")) {
                System.out.println(stack.stream().max((s, f) -> s.compareTo(f)).get());
            }
        }
    }
}
