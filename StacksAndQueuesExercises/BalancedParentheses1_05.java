package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses1_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        boolean isEquals = false;

        for (int i = 0; i < input.length(); i++) {

            char symbol = input.charAt(i);
            if(symbol == '[' || symbol == '{' || symbol == '(') {
                stack.push(symbol);
            } else {
                if(symbol == ')' && stack.pop() == '(') {
                    isEquals = true;
                } else if (symbol == ']' && stack.pop() == '[') {
                    isEquals = true;
                } else if (symbol == '}' && stack.pop() == '{') {
                    isEquals = true;
                } else {
                    isEquals = false;
                    break;
                }
            }
        }

        if(isEquals) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
