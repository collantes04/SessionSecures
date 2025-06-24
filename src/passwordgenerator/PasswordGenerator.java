package passwordgenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import passwordgenerator.generators.LowercaseLetter;
import passwordgenerator.generators.Symbol;
import passwordgenerator.generators.UppercaseLetter;

public class PasswordGenerator {
    /*attack attempts per second, the constant can be changed to cover the need for calculating
    the number of years needed to break the password*/
    private static final BigDecimal ATACK_ATTEMPTS = BigDecimal.valueOf(1000000);

    /*Do not change charset_size */
    private static final double CHARSET_SIZE = 91;

    /**
     * This method generates a random password
     * from length passed in parameters and returns the password
     * @param len the length you want the password to be
     * @return generated password as String
     * @throws IllegalArgumentException if the length is negative or less than eight
     */
    public String generatorPassword(long len){
        
        if (len < 8) {
            throw new IllegalArgumentException("Length is negative or minor to eight");
        }

        Random rand = new Random();
        int election;
        String password = "";
        long cont = 0;

        while (cont != len) {
            election = rand.nextInt(4);

            switch (election) {
                case 0:
                    //symbols
                    password += Symbol.retSymbol();
                    break;

                case 1:
                //numbers
                    password += rand.nextInt(10);
                    break;

                case 2:
                //uppercase
                    password += UppercaseLetter.upperRet();
                    break;

                case 3:
                //lowercase
                    password += LowercaseLetter.lowerRet();
                    break;

                default:

                break;
            }
            cont++;
        }


        return password;
    }

    /**
     * calculates and return the years it will take
     * for an attack to break the password
     * that will tell how safe it is
     *
     * @param pass the password to analyze
     * @return estimated time in seconds as BigDecimal
     */
    public BigDecimal passwordCalculator(String pass){
        
        BigDecimal base = BigDecimal.valueOf(CHARSET_SIZE);
        BigDecimal combinations = base.pow(pass.length());
        
        return combinations.divide(ATACK_ATTEMPTS, RoundingMode.HALF_UP);
    }


}
