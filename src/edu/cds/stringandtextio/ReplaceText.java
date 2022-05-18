package edu.cds.stringandtextio;

    //Section 8.23\\

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) {
        // Ensure proper usage
        if (args.length != 3) {
            System.out.printf("Usage: java %s  <fileName> [oldString] [newString]", ReplaceText.class.getName());
            System.exit(1);
        }

        // Create file object
        File file = new File(args[0]);

        // Ensure file exists
        if (!file.exists()) {
            System.out.printf("File [%s] does not exist", args[0]);
            System.exit(2);
        }

        // Read text into builder
        StringBuilder builder;
        try (Scanner reader = new Scanner(file)) {
            builder =  new StringBuilder(reader.nextLine());
            while (reader.hasNext())
                builder.append('\n').append(reader.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Edit text
        replace(builder, args[1], args[2]);

        // Write text into file
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(builder.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // DONE
    }

    // Replace old string with new string
    public static void replace(StringBuilder builder, String old, String current) {
        for (int i = 0; i < builder.length(); i++)
            if (builder.charAt(i) == 32 || i == builder.length() - 1)
                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0) {
                        if (builder.substring(j, i).equals(old))
                            builder.replace(j, i, current);
                        break;
                    }
                    if (builder.charAt(j) == 32) {
                        if (builder.substring(j + 1, i).equals(old))
                            builder.replace(j + 1, i, current);
                    }
                }
    }
}
