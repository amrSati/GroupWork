package edu.cds.stringandtextio;

    //Section 8.24\\

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class RemoveText {
    public static void main(String[] args) {
        // Ensure proper usage
        if (args.length != 2) {
            System.out.printf("Usage: java %s <fileName> [textToRemove]\n", RemoveText.class.getName());
            System.exit(1);
        }

        // Create file object
        File file = new File(args[0]);

        // Ensure file exists
        if (!file.exists()) {
            System.out.printf("File %s does not exist", args[0]);
            System.exit(2);
        }

        // Ensure text to remove is provided and is non of control characters
        if (args[1] == null || args[1].equals(" ") || args[1].equals("\n")) {
            System.out.println("INVALID INPUT!");
            System.exit(3);
        }
        String remove = args[1];

        // Read text from file
        StringBuilder builder;
        
        try (Scanner reader = new Scanner(file)) {
            builder = new StringBuilder(reader.nextLine());
            while (reader.hasNext())
                builder.append('\n').append(reader.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Remove word from text
        remove(builder, remove);

        // Write back text into file
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(builder.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // DONE
    }

    // Remove specified string from text
    public static void remove(StringBuilder builder, String word) {
        for (int i = 0; i < builder.length(); i++)
            if (builder.charAt(i) == 32 || i == builder.length() - 1)
                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0) {
                        if (builder.substring(j, i).equals(word) || builder.substring(j + 1, i).equals(word)) {
                            builder.replace(j, i, "");  break;
                        }

                        if (builder.substring(j, i + 1).equals(word) || builder.substring(j + 1, i + 1).equals(word))   builder.replace(j, i + 1, ""); break;
                    }
                    if (builder.charAt(j) == 32) {
                        if (builder.substring(j + 1, i).equals(word)) {
                            builder.replace(j, i, "");  break;
                        }

                        if (builder.substring(j + 1, i + 1).equals(word))   builder.replace(j, i + 1, "");  break;
                    }
                }
            // WOOF \\
    }
}