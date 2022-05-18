package edu.cds.basics;

    //section 7.12\\

import java.util.Scanner;

class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Construct new Stack
        StackOfIntegers integerStack = new StackOfIntegers();

        // Take input
        System.out.print("Enter a positive integer: ");
        int i = 2, num = sc.nextInt();

        // Push prime numbers into stack
        for (; i <= num; i++) {
            while ((num % i) == 0) {
                num /= i;
                integerStack.push(i);
            }
        }

        // Reverse order of numbers
        int[] rev = new int[integerStack.size()];

        for (i = 0; i < rev.length; i++)
            rev[i] = integerStack.pop();

        // Print reversed output
        System.out.print("reversed: ");
        for (i = 0; i < rev.length; i++)
            System.out.print(rev[i] + " ");

        System.out.println();

        // DONE
    }
}
