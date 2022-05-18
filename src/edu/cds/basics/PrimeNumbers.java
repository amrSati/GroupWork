package edu.cds.basics;

    //section 7.13\\

class PrimeNumbers {
    public static void main(String[] args) {
        int num = 120, i = num - 1;

        // Calculate prime numbers of integer and store into stack
        StackOfIntegers intStack = new StackOfIntegers();

        for (; i > 1; i--)
            if (MyInteger.isPrime(i))
                intStack.push(i);

        // Print prime numbers
        for (i = 0; i < intStack.size() - 1; i++)
            System.out.print(intStack.pop() + " ");

        // DONE
    }
}
