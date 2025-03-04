package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders_08 {
    public static void main(String[] args) {

        String path = "resources/Files-and-Streams";

        File root = new File(path);

        int counter = 0;

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            File file = queue.poll();

            System.out.println(file.getName());

            File[] files = file.listFiles();

            if (files != null) {

                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
            }

            counter++;
        }
        System.out.printf("%d folders", counter);
    }
}
