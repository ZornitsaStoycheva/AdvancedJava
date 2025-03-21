package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));

        String line = bufferedReader.readLine();

        int countVowels = 0;
        int countPunctuation = 0;
        int otherSymbol = 0;

        while (line != null) {

            char[] characterFromLine = line.toCharArray();

            for (char character : characterFromLine) {
                    if (character == 'A' || character == 'O' || character == 'I' || character == 'E' || character == 'U') {
                        countVowels ++;
                    } else if (character == '.' || character == '?' || character == '!' || character == ',') {
                        countPunctuation ++;
                    } else if (character != ' ') {
                        if (Character.isUpperCase(character)) {
                            otherSymbol ++;
                        }
                    }
            }

            line = bufferedReader.readLine();
        }

        System.out.printf("Vowels: %d%n", countVowels);
        System.out.printf("Other symbols: %d%n", otherSymbol);
        System.out.printf("Punctuation: %d%n", countPunctuation);
    }
}
