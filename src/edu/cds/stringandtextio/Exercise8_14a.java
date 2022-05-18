package edu.cds.stringandtextio;

    //Section 8.14\\
public class Exercise8_14a {
    public static void main(String[] args) {
        int sum = 0;

        // Sum given integers separated by blanks
        for (String digits: args)
            sum += Integer.parseInt(digits);

        // Print sum
        System.out.printf("total is: %d", sum);

        // DONE
    }
}
