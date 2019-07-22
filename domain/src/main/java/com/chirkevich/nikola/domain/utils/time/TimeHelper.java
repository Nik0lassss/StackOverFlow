package com.chirkevich.nikola.domain.utils.time;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeHelper {

    public boolean isMoreThen(Date firstDate, Date secondDate, int interval) {
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff > interval;
    }

    public boolean isMoreThenCurrentFor(Date firstDate, int interval) {
        Date currentDate = getCurrentDate();
        return isMoreThen(firstDate, currentDate, interval);
    }

    public Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}
