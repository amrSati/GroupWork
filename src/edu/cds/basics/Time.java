package edu.cds.basics;

//Section 7.7\\

class Time {

    private int hour;
    private int minute;
    private int second;

    public Time() {
        long timeMillis = System.currentTimeMillis();
        hour = (int) (((timeMillis / 1000) / 60) / 60) % 24;
        minute = (int) (((timeMillis / 1000) / 60) % 60);
        second = (int) ((timeMillis / 1000) % 60);
    }

    public Time(long timeMillis) {
        hour = (int) (((timeMillis / 1000) / 60) / 60) % 24;
        minute = (int) (((timeMillis / 1000) / 60) % 60);
        second = (int) ((timeMillis / 1000) % 60);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String getTime() {
        return String.format("%d:%02d:%02d %s",
                ((hour <= 12) ? hour : hour % 12),
                minute,
                second,
                ((hour > 12) ? "PM" : "AM"));
    }
}