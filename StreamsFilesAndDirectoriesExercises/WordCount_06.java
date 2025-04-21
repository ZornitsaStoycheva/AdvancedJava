package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resourcesExercise/words.txt"));

        PrintWriter printer = new PrintWriter(new FileWriter("results.txt"));

        Map<String, Integer> map = new HashMap<>();

        String words = bufferedReader.readLine().toString();
        String[] wordsArr = words.split(" ");

        int count = 0;

        for (int i = 0; i < wordsArr.length; i++) {
            String currentWord = wordsArr[i];

            BufferedReader inputText = new BufferedReader(new FileReader("resourcesExercise/text.txt"));

            String line = inputText.readLine();
            String[] text = line.split(" ");

            for (int j = 0; j < text.length; j++) {
                if (text[j].equals(currentWord)) {
                    count++;
                }

            }

            map.put(currentWord, count);
            count = 0;

        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
//        }

        Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());

        Stream<Map.Entry<String, Integer>> sorted1 = sorted.sorted((a, b) -> b.getValue().compareTo(a.getValue()));

        printer.print(sorted1);

        sorted1.forEach((x) -> System.out.printf("%s - %d%n", x.getKey(), x.getValue()));
    }
}
