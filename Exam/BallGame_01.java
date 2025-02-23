package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class BallGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> strength = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(strength::push);

        ArrayDeque<Integer> kick = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(kick::offer);


        int countGoal = 0;

        while (strength.size() > 0 || kick.size() > 0) {

            if (strength.size() == 0) {
                break;
            }

            if (kick.size() == 0) {
                break;
            }

            int lastStrength = strength.peek();

            int firstKick = kick.peek();

            int sum = lastStrength + firstKick;

            if (sum == 100) {
                strength.pop();
                kick.poll();
                countGoal++;
            } else if (sum < 100) {
                if (lastStrength < firstKick) {
                    strength.pop();
                } else if (lastStrength > firstKick){
                    kick.poll();
                } else {
                    strength.pop();
                    strength.push(sum);
                    kick.poll();
                }
            } else {
                strength.pop();
                strength.push(lastStrength - 10);
                kick.add(firstKick);
                kick.poll();
            }
        }

        if (countGoal == 3) {
            System.out.println("Paul scored a hat-trick!");
        } else if (countGoal == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (countGoal > 0 && countGoal < 3) {
            System.out.println("Paul failed to make a hat-trick.");
        } else if (countGoal > 3) {
            System.out.println("Paul performed remarkably well!");
        }

        if (countGoal > 0)  {
            System.out.printf("Goals scored: %d%n", countGoal);
        }

        if (!strength.isEmpty()) {
            ArrayDeque<Integer> str = new ArrayDeque<>();

            for (int x : strength) {
                str.push(x);
            }

            String output = str.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.printf("Strength values left: %s", output);

        }

        if (!kick.isEmpty()) {
            String output = kick.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.printf("Accuracy values left: %s", output);
        }
    }
}
