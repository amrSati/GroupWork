package edu.cds.stringandtextio;

//section 8.1\\

class CheckPalindrome {
    public static void main(String[] args) {
        String word = "mom";
        System.out.println(isPalindrome(word));
    }

    public static String reverse(String word) {
        StringBuilder copy = new StringBuilder();
        for (int i = (word.length() - 1); i > -1; i--)
            copy.append(word.charAt(i));

        return copy.toString();
    }

    public static boolean isPalindrome(String word) {
        String copy = reverse(word);
            //8.2\\
        return word.equals(copy) || word.equalsIgnoreCase(copy);
    }
}