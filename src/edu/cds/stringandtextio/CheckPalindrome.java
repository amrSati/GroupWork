package edu.cds.stringandtextio;

    //section 8.1, 8.2, 8.13\\

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.printf("%s", (isPalindrome(args[0]) ? "It is a Palindrome" : "It is not Palindrome"));
    }

    public static String reverse(String word) {
        // Convert into char array
        char[] arr = word.toCharArray();
        char[] copy = new char[arr.length];

        // Reverse word
        for (int i = 0; i < arr.length; i++)
            copy[arr.length - i - 1] = arr[i];

        return String.valueOf(copy);
    }

    // Check if palindrome case insensitive
    public static boolean isPalindrome(String word) {
        String copy = reverse(word);
        return word.equals(copy) || word.equalsIgnoreCase(copy);
    }
}