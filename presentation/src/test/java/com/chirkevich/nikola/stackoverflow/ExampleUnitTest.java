package com.chirkevich.nikola.stackoverflow;

import android.text.TextUtils;
import android.util.Log;

import com.chirkevich.nikola.stackoverflow.model.DataService;

import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Observable;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

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

    @Test
    public void testMock() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        List<String> data = new ArrayList<>();
        data.add("dataItem");
        data.add("dataItem2");
        Mockito.when(dataServiceMock.getDataById(Mockito.argThat(argument -> argument == null || argument.length() > 5))).thenReturn("dataItem");
        System.out.println("");
    }

    @Test
    public void testAnswer() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        Mockito.when(dataServiceMock.getDataById(Mockito.any())).thenAnswer(invocation ->
                invocation.<List<String>>getArgument(0).stream()
                        .map(id -> {
                            switch (id) {
                                case "a":
                                    return "dataItemA";
                                case "b":
                                    return "dataItemB";
                                default:
                                    return null;
                            }
                        }).collect(Collectors.toList()));

    }

    @Test
    public void testVerify() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        dataServiceMock.getDataById("1");
        dataServiceMock.getDataById("2");
        Mockito.verify(dataServiceMock, Mockito.times(2)).getDataById(Mockito.any());
    }
}