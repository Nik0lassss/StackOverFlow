package com.chirkevich.nikola.stackoverflow;

import android.text.TextUtils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import io.reactivex.Observable;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testDateParsing() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = "2";
        Integer strVal = Integer.parseInt(date);


    }

}