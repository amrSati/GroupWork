package edu.cds.stringandtextio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

    //Section 8.20\\

public class Count {
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
        StringBuilder builder = null;
        try (Scanner reader = new Scanner(file)) {
            builder = new StringBuilder(reader.nextLine());
            while (reader.hasNext())
                builder.append('\n').append(reader.nextLine());

            // Close reader
            reader.close();
        }

        // Append text file into string object
        String text = builder.toString();

        // Count characters, words and lines
        int chars = countChars(text);
        int words = countWords(text);
        int lines = countLines(text);

        // Print output
        System.out.printf("The file has: \n%d Characters, \n%d Words, \n%d Lines\n", chars, words, lines);

        // DONE
    }

    // Count number of characters in a text
    public static int countChars(String text) {
        int count = 0;
        char[] chars = text.toCharArray();

        // Excluding control characters
        for (char c: chars)
            if (c != '\r' && c != '\n')
                count++;

        return count;
    }

    // Count number of words in a text
    public static int countWords(String text) {
        int count = 1;

        // Words are separated by ' ', '\t', '\r' and '\n'
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ' || text.charAt(i) == '\t'
             || text.charAt(i) == '\r' || text.charAt(i) == '\n')
                count++;

        return count;
    }

    // Count number of lines in a text
    public static int countLines(String text) {
        int count = 1;

        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == '\n')
                count++;

        return count;
    }
}
