package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        int bytes = fileInputStream.read();

        while (bytes != -1) {

            char symbol = (char) bytes;

            if (!(symbol == '.' || symbol == ',' || symbol == '?' || symbol == '!')) {
                fileOutputStream.write(symbol);
            }

            bytes = fileInputStream.read();
        }
    }
}
