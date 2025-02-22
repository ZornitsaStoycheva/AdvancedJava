package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> quests = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {

            if (input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    vip.add(input);
                } else {
                    quests.add(input);
                }
            }

            input = scanner.nextLine();
        }

        String party = scanner.nextLine();

        while (!party.equals("END")) {

            if (Character.isDigit(party.charAt(0))) {
                if (vip.contains(party)) {
                    vip.remove(party);
                }
            } else {
                if (quests.contains(party)) {
                    quests.remove(party);
                }
            }

            party = scanner.nextLine();
        }

        int count = vip.size() + quests.size();

        System.out.println(count);

        if (!vip.isEmpty()) {
            vip.forEach(System.out::println);
        }

        if (!quests.isEmpty()) {
            quests.forEach(System.out::println);
        }
    }
}
