package edu.cds.stringandtextio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* CheckSubstring program

        Scanner in = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = in.nextLine();

        System.out.println("Enter a Substring: ");
        String subStr = in.nextLine();

        System.out.println(indexOf(str, subStr));

         */
    }

    /* Check if the given char is a decimal digit or not (according to ASCII) */
    private static boolean isDigit(char c) {
        return (c > 47 && c < 58);
    }

        //Section 8.2\\
    /* Check if a string is a substring of another and return index */
    public static int indexOf(String str, String subStr) {
        int index = -1, i = 0;

        // Locate starting index of substring
        for (; i < str.length(); i++)
            if (subStr.charAt(0) == str.charAt(i)) {
                index = i++; break;
            }

        // Insure it is a substring of the string
        if (index >= 0)
            for (int j = 1; i < str.length(); i++, j++)
                if (subStr.charAt(j) != str.charAt(i))  return -1;

        return index;
    }

        //Section 8.4\\
    /* Return number of occurrences of a specified char in a string */
    public static int count(String str, char c) {
        int count = 0;
        for(int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c)
                count++;

        return count;
    }

        //Section 8.5\\
    /* Return number of occurrences of digits in a string */
    public static int[] count(String str) {
        int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < str.length(); i++)
            if (isDigit(str.charAt(i)))
                digits[Integer.parseInt(String.valueOf(str.charAt(i)))]++;

        return digits;
    }

        //Section 8.6\\
    /* Return number of letters in a string */
    public static int countLetters(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++)
            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122))
                count++;

        return count;
    }

        //Section 8.7\\
    /* Convert a hexadecimal string to int */
    public static int parseHex(String hexStr) {
        int hex = 0;

        for (int i = hexStr.length() - 1, j = 0; i >= 0; i--, j++) {
            if (isDigit(hexStr.charAt(i)))
                hex += (int) Math.pow(16, j) * Integer.parseInt(String.valueOf(hexStr.charAt(i)));
            else
                hex += (int) Math.pow(16, j) * switch (hexStr.charAt(i)) {
                                                  case 'A' -> 10;
                                                  case 'B' -> 11;
                                                  case 'C' -> 12;
                                                  case 'D' -> 13;
                                                  case 'E' -> 14;
                                                  case 'F' -> 15;
                                                  default -> -1;
                                               };
        }

        return (hex < 0) ? -1 : hex;
    }

    //Section 8.8\\
    /* Convert a binary string to int */
    public static int parseBinary(String binStr) {
        int bin = 0;

        for (int i = binStr.length() - 1, j = 0; i >= 0; i--, j++) {
            if ((binStr.charAt(i) < 48 || binStr.charAt(i) > 49))
                return -1; // if the char is neither 0 nor 1

            bin += Math.pow(2, j) * Integer.parseInt(String.valueOf(binStr.charAt(i)));
        }

        return bin;
    }
}