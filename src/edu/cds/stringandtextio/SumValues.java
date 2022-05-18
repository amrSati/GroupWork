package edu.cds.stringandtextio;

import java.util.Scanner;
import java.util.regex.*;

    //Section 8.18\\

public class SumValues {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input from user
        System.out.println("Enter double values separated by spaces: ");
        String values = input.nextLine();

        // Create a pattern to extract digits
        Pattern pattern = Pattern.compile("[\\d+.\\d+]+");

        // Mach the pattern with input
        Matcher matcher = pattern.matcher(values);

        double sum = 0;

        // Sum the values then print the sum
        while (matcher.find())
            sum += Double.parseDouble(matcher.group());

        System.out.printf("the sum is: %.03f", sum);

        // DONE
    }
}
