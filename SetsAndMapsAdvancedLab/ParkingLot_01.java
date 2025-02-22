package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] data = input.split(",\\s+");
            String direction = data[0];
            String carNumber = data[1];

            if (direction.equals("IN")) {

                parking.add(carNumber);

            } else if (direction.equals("OUT")) {

                parking.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.forEach(System.out::println);
        }
    }
}
