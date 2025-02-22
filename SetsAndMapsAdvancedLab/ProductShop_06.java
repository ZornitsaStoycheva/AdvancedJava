package SetsAndMapsAdvancedLab;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, List<String[]>> shop = new TreeMap<>();

        while (!input.equals("Revision")) {

            String[] data = input.split(",\\s+");
            String magazine = data[0];
            String product = data[1];
            String price = data[2];

            if(!shop.containsKey(magazine)) {
                shop.put(magazine, new ArrayList<>());
                shop.get(magazine).add(new String[]{ product, price });
            } else  {
                shop.get(magazine).add(new String[]{ product, price });
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String[]>> entry : shop.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("Product: %s, Price: %.1f%n",
                        entry.getValue().get(i)[0],
                        Double.parseDouble((entry.getValue().get(i)[1])));

            }
        }

    }
}
