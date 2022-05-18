package edu.cds.basics;

    //Section 7.6\\

import java.util.Scanner;

public class PrintCalendar {

    public static StringBuilder output = new StringBuilder();

    /** Main method */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter year
        System.out.print("Enter full year (e.g., 2001): ");
        int year = input.nextInt();

        // Prompt the user to enter month
        System.out.print("Enter month in number between 1 and 12: ");
        int month = input.nextInt();

        // Print calendar for the month of the year
        printMonth(year, month);

        System.out.println(output.toString());
    }

    /** Print the calendar for a month in a year */
    public static void printMonth(int year, int month) {
        // Print the headings of the calendar
        printMonthTitle(year, month);

        // Print the body of the calendar
        printMonthBody(year, month);
    }

    /** Print the month title, e.g., May, 1999 */
    public static void printMonthTitle(int year, int month) {
        output.append("         ").append(getMonthName(month)).append(" ").append(year);
        output.append("\n-----------------------------\n");
        output.append(" Sun Mon Tue Wed Thu Fri Sat\n");
    }

    /** Get the English name for the month */
    public static String getMonthName(int month) {
        String monthName = switch (month) {
                                case 1 -> "January";
                                case 2 -> "February";
                                case 3 -> "March";
                                case 4 -> "April";
                                case 5 -> "May";
                                case 6 -> "June";
                                case 7 -> "July";
                                case 8 -> "August";
                                case 9 -> "September";
                                case 10 -> "October";
                                case 11 -> "November";
                                case 12 -> "December";
                                default -> "";
                            };

        return monthName;
    }

    /** Print month body */
    public static void printMonthBody(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++)
            output.append("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            output.append(String.format("%4d", i));

            if ((i + startDay) % 7 == 0)
                output.append("\n");
        }

        output.append("\n");
    }

    /** Get the start day of month/1/year */
    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /** Get the total number of days since January 1, 1800 */
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;

        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);

        return total;
    }

    /** Get the number of days in a month */
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0; // If month is incorrect
    }

    /** Determine if it is a leap year */
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}