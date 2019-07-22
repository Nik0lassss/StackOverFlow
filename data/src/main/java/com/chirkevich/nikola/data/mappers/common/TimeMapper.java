package com.chirkevich.nikola.data.mappers.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMapper {

    public long toLong(Date date) {
        return date.getTime();
    }

    public Date toDate(long date) {
        return new Date(date);
    }

}
