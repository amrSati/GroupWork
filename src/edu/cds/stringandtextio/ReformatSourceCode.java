package edu.cds.stringandtextio;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

    //Section 8.19\\

public class ReformatSourceCode {
    public static void main(String[] args) {
        // Ensure proper usage
        if (args.length != 1) {
            System.out.printf("Usage: java %s [filepath]", ReformatSourceCode.class.getName());
            System.exit(1);
        }

        // Create file object
        File file = new File(args[0]);

        // Ensure existence of file
        if (!file.exists()) {
            System.out.printf("File %s does not exist", args[0]);
            System.exit(2);
        }

        // Create an ArrayList
        ArrayList<String> list = new ArrayList<>();

        String string1;
        String string2;

        // Read text from file
        try (
                // Create scanner to read
                Scanner input = new Scanner(file)
        ) {
            /* *  Convert java source code from next-line brace style
               *  to the end-of-line brace style
               *  */
            string1 = input.nextLine();
            while (input.hasNext()) {
                string2 = input.nextLine();
                if (string2.length() > 0 && string2.charAt(string2.length() - 1) == '{') {
                    list.add(string1.concat(" {"));
                    string1 = input.nextLine();
                } else {
                    list.add(string1);
                    string1 = string2;
                }
            }

            list.add(string1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Write text back to file
        try (
                // Create writer to write
                PrintWriter output = new PrintWriter(file)
        ) {
            for (String line: list)
                output.println(line);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // DONE
    }
}
