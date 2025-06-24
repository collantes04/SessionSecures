package passwordgenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class TimeUtils {

    public static String formatYearTime(BigDecimal time){

        /*
         * This method formats the time in seconds to years 
         * that it would take the key to break.
         * 
         * @param time Time in seconds like BigDecimal for more precision
         */
        BigDecimal secondsInYear = BigDecimal.valueOf(60L * 60L * 24L * 365L);
        BigDecimal years = time.divide(secondsInYear, 2, RoundingMode.HALF_UP);

        return String.format("%.2f years to break this password", years.doubleValue());
    }
}
