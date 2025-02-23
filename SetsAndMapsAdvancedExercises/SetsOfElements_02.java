package SetsAndMapsAdvancedExercises;

import java.util.*;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> n = new LinkedHashSet<>();

        Set<Integer> m = new LinkedHashSet<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr[0]; i++) {
            int digit = Integer.parseInt(scanner.nextLine());

            if (!n.contains(digit)) {
                n.add(digit);
            }
        }

        for (int i = 0; i < arr[1]; i++) {
            int digit = Integer.parseInt(scanner.nextLine());

            if (!m.contains(digit)) {
                m.add(digit);
            }
        }

        while (n.size() > 0) {
            int first = n.iterator().next();
            n.remove(first);

            if(m.contains(first)) {
                System.out.print(first + " ");
            }
        }

    }
}
