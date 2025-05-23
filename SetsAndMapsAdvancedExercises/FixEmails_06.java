package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {

            String email = scanner.nextLine();

            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
                name = scanner.nextLine();
                continue;
            } else {
                if (!emails.containsKey(name)) {
                    emails.put(name, email);
                }
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n",
                    entry.getKey(),
                    entry.getValue());
        }

    }
}
