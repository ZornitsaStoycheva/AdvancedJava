package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Double[]> mapGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            String[] grades = scanner.nextLine().split(" ");

            Double[] arr = new Double[grades.length];

            for (int j = 0; j < grades.length; j++) {
                arr[j] = Double.parseDouble(grades[j]);
            }
            mapGrades.put(student, arr);
        }

        for (Map.Entry<String, Double[]> entry : mapGrades.entrySet()) {

            DecimalFormat df = new DecimalFormat("#.##############");

            double average = Arrays.stream(entry.getValue()).mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.printf("%s is graduated with %s%n",
                    entry.getKey(),
                    df.format(average));
        }

    }
}
