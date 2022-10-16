package edu.virginia.cs.threelayer.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringFactory {
    public static final DateFormat dateStringFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getDateString(Date date) {
        return dateStringFormat.format(date);
    }
}
