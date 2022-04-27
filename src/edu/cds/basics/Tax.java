package edu.cds.basics;

//Section 7.14\\

class Tax {

    public static final int SINGLE_FILER = 0,
                            MARRIED_JOINTLY = 1,
                            MARRIED_SEPARATELY = 2,
                            HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int brackets[][];
    private double rates[];
    private double taxableIncome;

    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = (filingStatus < 0 || filingStatus > 3) ? -1 : filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }
}