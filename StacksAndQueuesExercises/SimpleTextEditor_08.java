package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            if(input[0].equals("1")) {
                text += input[1];
                stack.push(input[1]);

            } else if (input[0].equals("2")) {
                int count = Integer.parseInt(input[1]);
                text = text.substring(0, text.length() - count);

            } else if (input[0].equals("3")) {
                int print = Integer.parseInt(input[1]);
                System.out.println(text.charAt(print - 1));

            } else if (input[0].equals("4")) {
                text = stack.pop();
            }
        }
    }
}
