package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Zornitsa\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            int bytes = fileInputStream.read();

            while (bytes != -1) {

                    System.out.printf("%s ", Integer.toBinaryString(bytes));


                bytes = fileInputStream.read();
            }

            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException("The file " + path + " is missing.");
        }
    }
}
