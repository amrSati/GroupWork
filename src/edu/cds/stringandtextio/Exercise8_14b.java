package edu.cds.stringandtextio;

    //Section 8.14\\
public class Exercise8_14b {
    public static void main(String[] args) {
        int sum = 0;

        // Convert into array
        char[] digits = args[0].toCharArray();

        // Sum given integers
        for (char d: digits)
            if (Character.isDigit(d))
                sum += Integer.parseInt(String.valueOf(d));

        // Print sum
        System.out.printf("total is: %d", sum);

        // DONE
    }
}
