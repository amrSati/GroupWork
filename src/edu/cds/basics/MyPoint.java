package edu.cds.basics;

//Section 7.11\\

class MyPoint {

    private float x;
    private float y;

    public MyPoint() {
        x = y = 0;
    }

    public MyPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // Return Euclidean distance for a MyPoint object
    public double distance(MyPoint points) {
        double dist = Math.pow((x - points.getX()), 2)
                + Math.pow((y - points.getY()), 2);
        return Math.sqrt(dist);
    }

    // Return Euclidean distance for given coordinates
    public double distance(float x, float y) {
        double dist = Math.pow((this.x - x), 2)
                + Math.pow((this.y - y), 2);
        return Math.sqrt(dist);
    }
}