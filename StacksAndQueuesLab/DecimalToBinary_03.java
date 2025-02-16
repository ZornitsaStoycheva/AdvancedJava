package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int decimal = number;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if(number == 0) {
            System.out.print(0);
        } else {
            while (decimal > 0) {
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }

        if(!stack.isEmpty()) {
            for (Integer integer : stack) {
                System.out.print(integer);
            }
        }
    }
}
