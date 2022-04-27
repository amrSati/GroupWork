package edu.cds.basics;

//Section 7.1\\

class Rectangle {

    private double height;
    private double width;
    private String color;

    public Rectangle() {
        this.height = 1;
        this.width = 1;
        this.color = "white";
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }

    public double getDiagonal() {
        double diag = height * height;
        diag += (width * width);
        return Math.sqrt(diag);
    }
}