package SetsAndMapsAdvancedLab;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> averageGrade = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String student = data[0];
            double grade = Double.parseDouble(data[1]);

            if(!averageGrade.containsKey(student)) {
                averageGrade.put(student, new ArrayList<>());
                averageGrade.get(student).add(grade);
            } else {
                averageGrade.get(student).add(grade);
            }
        }

        for (Map.Entry<String, ArrayList<Double>> entry : averageGrade.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().forEach(x -> System.out.printf("%.2f ", x));
            System.out.printf("(avg: %.2f)%n", average);
        }

    }
}
