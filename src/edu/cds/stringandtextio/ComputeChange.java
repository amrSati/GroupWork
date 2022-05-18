package edu.cds.stringandtextio;

import java.util.Scanner;

    //Section 8.16\\

public class ComputeChange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.println("Enter amount in double: ");
        String amount = input.next();

        // Split input with comma
        String[] splitted = amount.split("\\.");

        // Print change
        System.out.printf("dollars: %s\n", splitted[0]);
        System.out.printf("cents: %s\n", splitted[1]);

        // DONE
    }
}
