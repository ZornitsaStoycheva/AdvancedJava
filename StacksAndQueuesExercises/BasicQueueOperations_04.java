package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s++");
        String[] numbers = scanner.nextLine().split("\\s++");

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int numbersOfQueue = Integer.parseInt(input[0]);
        int numbersOfPoll = Integer.parseInt(input[1]);
        int searchNumber = Integer.parseInt(input[2]);

        for (int i = 0; i < numbersOfQueue; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numbersOfPoll; i++) {
            queue.poll();
        }

        if(queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(searchNumber)) {
            System.out.println("true");
        } else {
            System.out.println(queue.stream().min((s, f) -> s.compareTo(f)).get());
        }
    }
}
