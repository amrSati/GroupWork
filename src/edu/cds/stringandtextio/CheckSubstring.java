package edu.cds.stringandtextio;

    //Section 8.3\\

import java.util.Scanner;

public class CheckSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = in.nextLine();

        System.out.println("Enter a Substring: ");
        String subStr = in.nextLine();

        // Print index of start of substring in string
        System.out.println(indexOf(str, subStr));

        // DONE
    }

    /* Check if a string is a substring of another and return index */
    public static int indexOf(String str, String subStr) {
        int index = -1, i = 0;

        // Locate starting index of substring
        for (; i < str.length(); i++)
            if (subStr.charAt(0) == str.charAt(i)) {
                index = i++; break;
            }

        // Ensure it is a substring of the string
        if (index >= 0)
            for (int j = 1; i < str.length(); i++, j++)
                if (subStr.charAt(j) != str.charAt(i))  return -1;

        return index;
    }

}
