package edu.cds.basics;

//Section 7.9\\

public class MyInteger {

    private final int myInt;

    public MyInteger(int myInt) {
        this.myInt = myInt;
    }

    public int getMyInt() {
        return myInt;
    }

    public boolean isEven() {
        return (myInt % 2) == 0;
    }

    public static boolean isEven(int x) {
        return (x % 2) == 0;
    }

    public static boolean isEven(MyInteger x) {
        return (x.getMyInt() % 2) == 0;
    }

    public boolean isOdd() {
        return (myInt % 2) != 0;
    }

    public static boolean isOdd(int x) {
        return (x % 2) != 0;
    }

    public static boolean isOdd(MyInteger x) {
        return (x.getMyInt() % 2) != 0;
    }

    public boolean isPrime() {
        return isPrime(myInt);
    }

    public static boolean isPrime(int x) {
        int y = x - 1;

        for (; y > 1; y--)
            if ((x % y) == 0)
                return false;

        return true;
    }

    public static boolean isPrime(MyInteger x) {
        return isPrime(x.getMyInt());
    }

    public boolean equals(int x) {
        return myInt == x;
    }

    public boolean equals(MyInteger x) {
        return myInt == x.getMyInt();
    }

    // Convert digits string into integer
    public static int parseInt(String digit) {
        int num = 0, l = 1, i = digit.length() - 1;

        for (; i >= 0; i--) {
            // if string contains characters other than digits, exit
            if (digit.charAt(i) < 48 || digit.charAt(i) > 57)
                return -1;

            num += (digit.charAt(i) - 48) * l;
            l *= 10;
        }

        return num;
    }
}