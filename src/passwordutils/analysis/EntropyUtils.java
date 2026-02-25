package passwordutils.analysis;

import java.math.BigDecimal;
import java.math.RoundingMode;

import passwordutils.utils.TimeUtils;


/**
 * The class that StrengtTools uses to calculate
 * @author Jose A. Sánchez
 * @version 1.0
 */
public class EntropyUtils {
    /*
     * Attack attempts per second, the constant can be changed to cover the need for
     * calculating
     * the number of years needed to break the password
     */
    private static final BigDecimal ATACK_ATTEMPTS = BigDecimal.valueOf(1000000000);

    /* Do not change charset_size */
    private static final double CHARSET_SIZE = 91;

    /* ===== Package-level access for StrengthTools ===== */

    protected BigDecimal passwordCalculator(String pass) {
        BigDecimal base = BigDecimal.valueOf(CHARSET_SIZE);
        BigDecimal combinations = base.pow(pass.length());

        // tiempo esperado
        combinations = combinations.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
        return combinations.divide(ATACK_ATTEMPTS, RoundingMode.HALF_UP); // segundos
    }

    protected BigDecimal bitEntropy(String password) {
        BigDecimal entropy = BigDecimal.ZERO;
        BigDecimal passLength = BigDecimal.valueOf(password.length());

        double log2x = Math.log(CHARSET_SIZE) / Math.log(2);

        entropy = passLength.multiply(BigDecimal.valueOf(log2x));

        return entropy;
    }

    /**
     * Calculates and return the years it will take
     * for an attack to break the password
     * that will tell how safe it is
     *
     * @param pass the password to analyze
     * @return estimated time in seconds as BigDecimal
     */

    protected String calculateInYears(String password) {
        BigDecimal yearsToBreak = passwordCalculator(password);
        return TimeUtils.formatYearTime(yearsToBreak);
    }
}
