package edu.cds.stringandtextio;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

    //Section 8.21\\

public class Scores {
    public static void main(String[] args) throws IOException {
        // Ensure proper usage
        if (args.length != 1) {
            System.out.printf("Usage: java %s [filepath]", Count.class.getName());
            System.exit(1);
        }

        // Create file object
        File file = new File(args[0]);

        // Ensure file exist
        if (!file.exists()) {
            System.out.printf("File [%s] does not exist", args[0]);
            System.exit(2);
        }

        // Read text from file
        StringBuilder builder;
        try (Scanner scanner = new Scanner(file)) {
            builder = new StringBuilder(scanner.nextLine());
            while (scanner.hasNext())
                builder.append(scanner.nextLine());
        }
        String scores = builder.toString();

        // Calculate the number of scores, the sum and the average
        int count = numberOfScores(scores);
        int sum = sumOfScores(scores);
        int avg = sum / count;

        // Print output
        System.out.printf("the sum: %d \nthe average: %d\n", sum, avg);

        // DONE
    }

    // Return number of scores in file
    public static int numberOfScores(String scores) {
        int count = 1;

        // Scores are separated by blanks
        for (int i = 0; i < scores.length(); i++)
            if (scores.charAt(i) == 32)
                count++;

        return count;
    }

    // Return the sum of scores
    public static int sumOfScores(String scores) {
        int sum = 0;

        for (int i = 0; i < scores.length(); i++)
            if (scores.charAt(i) == 32 || scores.charAt(i) == (scores.length() - 1))
                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0) {
                        sum += Integer.parseInt(scores.substring(j, i));    break;
                    }
                    if (scores.charAt(j) == 32) {
                        sum += Integer.parseInt(scores.substring(j + 1, i));    break;
                    }
                }

        return sum;
    }
}
