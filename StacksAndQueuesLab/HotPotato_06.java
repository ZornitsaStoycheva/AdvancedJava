package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < number; i++) {
                queue.offer(queue.poll());
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
