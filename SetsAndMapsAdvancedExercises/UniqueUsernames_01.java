package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniquePassword = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();

            if (!uniquePassword.contains(password)) {
                uniquePassword.add(password);
            }
        }

        uniquePassword.forEach(System.out::println);
    }
}
