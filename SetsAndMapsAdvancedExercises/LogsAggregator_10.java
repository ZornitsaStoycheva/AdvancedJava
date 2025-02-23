package SetsAndMapsAdvancedExercises;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogsAggregator_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer>> users = new TreeMap<>();
        Map<String, Set<String>> ip = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("\\s+");

            String IP = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
                users.get(user).put(IP, duration);
            } else {
                Map<String, Integer> map = users.get(user);
                if(!map.containsKey(IP)) {
                    map.put(IP, duration);
                } else {
                    map.put(IP, map.get(IP) + duration);
                }
            }

            if (!ip.containsKey(user)) {
                ip.put(user, new LinkedHashSet<>());
                ip.get(user).add(IP);
            } else {
                ip.get(user).add(IP);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            Map<String, Integer> value = entry.getValue();


            System.out.printf("%s: %d %n",
                    entry.getKey(),
                    sum);



//            for (Map.Entry<String, Integer> entryValue : value.entrySet()) {
//                System.out.printf("[%s,]%n",
//                        entryValue.getKey());
//            }

        }



    }
}
