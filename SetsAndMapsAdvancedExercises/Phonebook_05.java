package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {

            String[] data = input.split("-");

            String name = data[0];

            String phone = data[1];

            if(!phonebook.containsKey(name)) {
                phonebook.put(name, phone);
            }

            input = scanner.nextLine();
        }

        String search = scanner.nextLine();

        while (!search.equals("stop")) {

            if (phonebook.containsKey(search)) {
                System.out.printf("%s -> %s%n",
                        search,
                        phonebook.get(search));
            } else {
                System.out.printf("Contact %s does not exist.%n",
                        search);
            }

            search = scanner.nextLine();
        }
    }
}
