package passwordutils.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;


public final class TimeUtils {

    /**
     * This method formats the time in seconds to years 
     * that it would take the key to break.
     *
     * @param time Time in seconds like BigDecimal for more precision
     */
    public static String formatYearTime(BigDecimal time){

        BigDecimal secondsInYear = BigDecimal.valueOf(60L * 60L * 24L * 365L);
        BigDecimal years = time.divide(secondsInYear, 2, RoundingMode.HALF_UP);
        
        return years.setScale(2, RoundingMode.HALF_UP).toPlainString() + " years";
    }

    /**
     * This method formats the time in seconds to years and day
     * that it would take the key to break.
     *
     * @param time Time in seconds like BigDecimal for more precision
     */

    public static String formatDateTime(BigDecimal time){
        
        BigDecimal SECONDS_IN_YEAR = BigDecimal.valueOf(60L * 60L * 24L * 365L);
        BigDecimal SECONDS_IN_DAY = BigDecimal.valueOf(60L * 60L * 24L);

        BigDecimal years = time.divide(SECONDS_IN_YEAR, 0, RoundingMode.DOWN);

        BigDecimal remainingSeconds = time.remainder(SECONDS_IN_YEAR);

        BigDecimal days = remainingSeconds.divide(SECONDS_IN_DAY, 0, RoundingMode.DOWN);

        return years + " years and " + days + " days to break this password";
    }
}
