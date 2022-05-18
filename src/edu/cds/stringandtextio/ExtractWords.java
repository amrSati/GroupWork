package edu.cds.stringandtextio;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    //Section 8.17\\

public class ExtractWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input from user
        System.out.println("enter a string: ");
        String text = input.nextLine();

        // Make a pattern to extract words
        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        // Mach the pattern with input
        Matcher matcher = pattern.matcher(text);

        int i = 0;
        // Print words in text
        while (matcher.find())
            System.out.printf("word %d: %s\n", ++i, matcher.group());

        // Done
    }
}
