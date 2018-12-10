/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 *
 * @author patryk
 */
public class RandomData {
    
    
    private static Random random = new Random();
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static int randomNumber(int min, int max) {
        int totalNumber = 1;
        IntStream stream = random.ints(totalNumber, min, max);
        return stream.sum();
    }

    public static String randomString(int lenght) {
        StringBuilder builder = new StringBuilder();
        while (lenght-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString().toUpperCase();
    }
    
     public static Date randomDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String str_date1 = "1970-01-01";
        String str_date2 = "2018-12-31";

        cal.setTime(formatter.parse(str_date1));
        Long value1 = cal.getTimeInMillis();

        cal.setTime(formatter.parse(str_date2));
        Long value2 = cal.getTimeInMillis();

        long value3 = (long) (value1 + Math.random() * (value2 - value1));
        cal.setTimeInMillis(value3);
        return cal.getTime();
    }

    public static double randomDouble(int min, int max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    
}
