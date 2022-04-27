package edu.cds.basics;

import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        //section 7.5*\\
        /*

        GregorianCalendar cal = new GregorianCalendar();
        logger.info("year: " + cal.get(GregorianCalendar.YEAR)
                        + " month: " + cal.get(GregorianCalendar.MONTH)
                        + " day: " + cal.get(GregorianCalendar.DAY_OF_MONTH));

        */


        /////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////

        //section 7.12\\
        /*

        Scanner sc = new Scanner(System.in);

        StackOfIntegers integerStack = new StackOfIntegers();

        System.out.println("Enter a positive integer: ");
        int i = 2, num = sc.nextInt();

        for (; i <= num; i++) {
            while ((num % i) == 0) {
                num /= i;
                integerStack.push(i);
            }
        }

        System.out.println(integerStack);
        int rev[] = new int[integerStack.size()];

        for (i = 0; i < rev.length; i++)
            rev[i] = integerStack.pop();

        System.out.print("reversed: ");
        for (i = 0; i < rev.length; i++)
            System.out.print(rev[i] + " ");

        System.out.println();

         */

        ///////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

        //section 7.13\\
        /*

        int num = 120, i = num - 1;
        StackOfIntegers intStack = new StackOfIntegers();
        for (; i > 1; i--)
            if (MyInteger.isPrime(i))
                intStack.push(i);

        System.out.println(intStack);

         */
    }
}