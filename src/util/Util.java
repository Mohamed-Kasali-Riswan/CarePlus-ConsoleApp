package util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	//--------------------------- Get current UTC time in milliseconds
    public static long nowToUtcMillis() {
        return Instant.now().toEpochMilli();
    }
    
	//--------------------------- Get UTC time after specific days in milliseconds
    public static long nowPlusDaysToUtcMillis(int days) {
        return Instant.now().plus(Duration.ofDays(days)).toEpochMilli();
    }

    //--------------------------- Convert UTC millis to string (date only)
    public static String utcMillisToDate(long utcMillis) {
    	String pattern="yyyy-MM-dd";
        Instant instant = Instant.ofEpochMilli(utcMillis);
        ZonedDateTime zdt = instant.atZone(ZoneOffset.UTC); // Ensure consistent output
        return zdt.format(DateTimeFormatter.ofPattern(pattern));
    }

}
