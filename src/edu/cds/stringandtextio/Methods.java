package edu.cds.stringandtextio;

    //Sections 8.4-8.12\\

import java.util.Stack;

public class Methods {

    /* Convert digits to char */
    private static char toChar(int x) {
        return switch (x) {
            case 0 -> 48;
            case 1 -> 49;
            case 2 -> 50;
            case 3 -> 51;
            case 4 -> 52;
            case 5 -> 53;
            case 6 -> 54;
            case 7 -> 55;
            case 8 -> 56;
            case 9 -> 57;
            case 10 -> 65;
            case 11 -> 66;
            case 12 -> 67;
            case 13 -> 68;
            case 14 -> 69;
            case 15 -> 70;
            default -> ' ';
        };
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
            if (Character.isDigit(str.charAt(i)))
                digits[Integer.parseInt(String.valueOf(str.charAt(i)))]++;

        return digits;
    }

        //Section 8.6\\
    /* Return number of letters in a string */
    public static int countLetters(String str) {
        int count = 0;
        char[] arr = str.toCharArray();

        for (char c : arr)
            if (Character.isLetter(c))
                count++;

        return count;
    }

        //Section 8.7\\
    /* Convert a hexadecimal string to int */
    public static int parseHex(String hexStr) {
        int hex = 0;

        for (int i = hexStr.length() - 1, j = 0; i >= 0; i--, j++) {
            if (Character.isDigit(hexStr.charAt(i)))
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

        //Section 8.9\\
    /* Convert decimal to hexadecimal string */
    public static String decimalToHex(int val) {
        // Builder to build the decimal string from the stack
        StringBuilder decimal = new StringBuilder();
        Stack<Character> stackOfHex = new Stack<>();

        // Compute hexadecimal values and push into stack
        int r = 0;
        while (val != 0) {
            r = val % 16;
            stackOfHex.push(toChar(r)); // the first in is the Least Significant Digit
            val /= 16;
        }

        // Build string
        while (!stackOfHex.isEmpty())
            decimal.append(stackOfHex.pop());

        return decimal.toString();
    }

        //Section 8.10\\
    /* Convert decimal to Binary String */
    public static String decimalToBinary(int val) {
        StringBuilder decimal = new StringBuilder();
        Stack<Integer> binaries = new Stack<>();

        while (val != 0) {
            binaries.push(((val % 2 == 0) ? 0 : 1));
            val /= 2;
        }

        while (!binaries.isEmpty())
            decimal.append(binaries.pop());

        return decimal.toString();
    }

        //Section 8.11\\
    /* Sorting characters in a String */
    public static String sort(String str) {
        // Convert to char array
        char[] arr = str.toCharArray();

        // Bubble Sort Algorithm
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j+1] and arr[j]
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        // Append into builder
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: arr)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }

        //Section 8.12\\
    /* Check whether two words are Anagrams */
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        // Convert into arrays for easy checking
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int count = 0;

        for (char c1: arr1)
            for (char c2: arr2)
                if (c1 == c2) {
                    count++;
                    break;
                }

        return (count == s1.length());
    }

    // DONE
}