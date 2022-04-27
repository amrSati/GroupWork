package edu.cds.basics;

//Section 7.4\\

class Stock {

    private String symbol;
    private String name;
    private double preClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        preClosingPrice = 0;
        currentPrice = 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreClosingPrice() {
        return preClosingPrice;
    }

    public void setPreClosingPrice(double preClosingPrice) {
        this.preClosingPrice = preClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double changePercent() {
        return (((currentPrice - preClosingPrice) / preClosingPrice) * 100);
    }
}