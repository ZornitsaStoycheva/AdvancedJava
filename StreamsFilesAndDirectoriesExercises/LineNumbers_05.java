package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resourcesExercise/inputLineNumbers.txt"));

        PrintWriter printer = new PrintWriter(new FileWriter("line-numbers.txt"));

        String line = bufferedReader.readLine();

        int countLine = 1;

        while (line != null) {

            String output = countLine + ". " + line;
            printer.print(output);

            printer.println();

            countLine ++;

            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        printer.close();
    }
}
