package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resourcesExercise/input.txt"));


        PrintWriter printer = new PrintWriter(new FileWriter("all-capitals.txt"));

        String line = bufferedReader.readLine();

        while (line != null) {
            String output = line.toUpperCase();
            printer.print(output);

            printer.println();

            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        printer.close();
    }
}
