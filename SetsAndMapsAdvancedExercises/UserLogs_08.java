package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] data = input.split("\\s+");

            String dataIP = data[0];

            String dataUser = data[2];

            String[] IP = dataIP.split("=");

            String[] user = dataUser.split("=");

            String addressIP = IP[1];

            String username = user[1];

            if (!users.containsKey(username)) {
                users.put(username, new LinkedHashMap<>());
                users.get(username).put(addressIP, 1);
            } else {
                Map<String, Integer> map = users.get(username);

                if (!map.containsKey(addressIP)) {
                    map.put(addressIP, 1);
                } else {
                    map.put(addressIP, map.get(addressIP) + 1);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (Map.Entry<String, Integer> entryValue : entry.getValue().entrySet()) {

                System.out.printf("%s => %d. %n",
                        entryValue.getKey(),
                        entryValue.getValue());

            }

        }

    }
}
