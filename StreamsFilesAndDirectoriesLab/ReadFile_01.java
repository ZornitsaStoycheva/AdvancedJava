package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFile_01 {
    public static void main(String[] args) {

        String path = "resources/input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            FileOutputStream fileOutputStream = new FileOutputStream("readFile.txt");

            PrintWriter printer = new PrintWriter(fileOutputStream);

            int bytes = fileInputStream.read();

            while (bytes != -1) {

                    printer.print(Integer.toBinaryString(bytes) + " ");

                bytes = fileInputStream.read();
            }

            printer.print(System.lineSeparator());

        } catch (IOException e) {
            throw new RuntimeException("The file " + path + " is missing.");
        }
    }
}
