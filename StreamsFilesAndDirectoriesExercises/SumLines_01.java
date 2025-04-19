package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resourcesExercise/input.txt"));

        String line = bufferedReader.readLine();

        while (line != null) {

            long sum = 0;

            char[] characterFromLine = line.toCharArray();

            for(char character : characterFromLine) {
                sum += character;
            }

            System.out.println(sum);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}
