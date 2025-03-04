package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        FileOutputStream fileOutputStream = new FileOutputStream("write-every-third-line");

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        String line = reader.readLine();

        int counter = 1;

        while (line != null) {

            if (counter % 3 == 0) {
                output.write(line);
                output.newLine();
            }

            line = reader.readLine();

            counter++;

        }
        output.flush();
        output.close();
    }
}
