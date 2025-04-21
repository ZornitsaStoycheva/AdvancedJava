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

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resourcesExercise/input.txt"));

        String line = bufferedReader.readLine();

        int countVowels = 0;
        int countPunctuation = 0;
        int otherSymbol = 0;

        while (line != null) {

            char[] characterFromLine = line.toCharArray();

            for (char character : characterFromLine) {
                    if (character == 'a' || character == 'o' || character == 'i' || character == 'e' || character == 'u') {
                        countVowels ++;
                    } else if (character == '.' || character == '?' || character == '!' || character == ',') {
                        countPunctuation ++;
                    } else  {
                        if (character != ' ') {
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
