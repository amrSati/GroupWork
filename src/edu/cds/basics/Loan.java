package edu.cds.basics;

//Section 7.10\\

import java.util.Date;

class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // Construct new instance
    public Loan() {
        annualInterestRate = 0;
        numberOfYears = 0;
        loanAmount = 0;
        loanDate = new Date();
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment(annualInterestRate, numberOfYears, loanAmount);
    }

    public double getTotalPayment() {
        return totalPayment(annualInterestRate, numberOfYears, loanAmount);
    }

    // Calculate monthly payment
    public static double monthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        // Divide the algorithm to be more readable
        double pay = (annualInterestRate / 100) * loanAmount;
        pay *= numberOfYears;
        pay += loanAmount;
        pay /= 12;
        return pay;
    }

    // Calculate total payment of the loan
    public static double totalPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        double total = (annualInterestRate / 100) * loanAmount;
        total *= numberOfYears;
        total += loanAmount;
        return total;
    }
}