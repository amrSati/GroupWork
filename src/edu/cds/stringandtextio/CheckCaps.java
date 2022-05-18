package edu.cds.stringandtextio;

    //Section 8.15\\

public class CheckCaps {
    public static void main(String[] args) {
        int caps = 0;

        // Separate characters in string
        char[] chars = null;

        // Count in each string
        for (String str: args) {
            chars = str.toCharArray();

            for (char c: chars)
                if (Character.isUpperCase(c))
                    caps++;
        }

        // DONE
    }
}
