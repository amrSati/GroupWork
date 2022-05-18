package edu.cds.basics;

    //section 7.5*\

import java.util.GregorianCalendar;
import java.util.logging.Logger;

class CalendarProgram {
    // Instantiate a logger
    public static final Logger logger = Logger.getLogger(CalendarProgram.class.getName());

    public static void main(String[] args) {
        // Construct new GregorianCalendar
        GregorianCalendar cal = new GregorianCalendar();

        // Print date info
        logger.info("year: " + cal.get(GregorianCalendar.YEAR)
                        + " month: " + cal.get(GregorianCalendar.MONTH)
                        + " day: " + cal.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
