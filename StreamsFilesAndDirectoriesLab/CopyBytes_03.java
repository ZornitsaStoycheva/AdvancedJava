package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        FileOutputStream fileOutputStream = new FileOutputStream("outputCopyBytes.txt");

        PrintWriter printer = new PrintWriter(fileOutputStream);

        int bytes = fileInputStream.read();

        while (bytes != -1) {

            char symbol = (char) bytes;

            if (!(symbol == ' ' || symbol == '\n')) {
                printer.print((int) symbol);
            } else {
                printer.print(symbol);
            }

            bytes = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
