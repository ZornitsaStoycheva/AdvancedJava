package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resourcesExercise/input.txt"));

        String line = bufferedReader.readLine();

        long sum = 0;

        while (line != null) {

            char[] characterFromLine = line.toCharArray();

            for(char character : characterFromLine) {
                sum += character;
            }

            line = bufferedReader.readLine();
        }

        System.out.println(sum);
        bufferedReader.close();
    }
}
