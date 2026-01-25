package passwordutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import passwordutils.generators.LowercaseLetter;
import passwordutils.generators.Symbol;
import passwordutils.generators.UppercaseLetter;


public class PasswordGenerator {
    /*Attack attempts per second, the constant can be changed to cover the need for calculating
    the number of years needed to break the password*/
    private static final BigDecimal ATACK_ATTEMPTS = BigDecimal.valueOf(1000000000);

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

   
    private BigDecimal passwordCalculator(String pass){
        BigDecimal base = BigDecimal.valueOf(CHARSET_SIZE);
        BigDecimal combinations = base.pow(pass.length());

        // tiempo esperado
        combinations = combinations.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);

        return combinations.divide(ATACK_ATTEMPTS, RoundingMode.HALF_UP); // segundos
    }


    /**
     * Analyzes the password passed by parameters under the criteria of:
     * +8 length and at least one uppercase letter, one lowercase letter,
     *  one symbol, and one number
     * 
     * @param password password to analyce
     * @return boolean true or false if the password is secure
     */

    public boolean secureBreach(String password){
        boolean hasLow = false;
        boolean hasUp = false;
        boolean hasSym = false;
        boolean hasNum = false;
        boolean state = false;


        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasNum = true;
                } else if(Character.isUpperCase(c)){
                    hasUp = true;
                } else if(Character.isLowerCase(c)){
                    hasLow = true;
                } else if(Symbol.isSymbol(c)){
                    hasSym = true;
                }
            }
        }

        if (hasNum && hasSym && hasUp && hasLow) {
            state = true;
        }
        
        return state;
    }


    private BigDecimal bitEntropy(String password){
        BigDecimal entropy = BigDecimal.ZERO;
        BigDecimal passLength = BigDecimal.valueOf(password.length());

        double log2x = Math.log(CHARSET_SIZE) / Math.log(2);

        entropy = passLength.multiply(BigDecimal.valueOf(log2x));

        return entropy;
    }
    
    /**
     * Evaluates the security level of a password based on its calculated bit entropy.
     *
     * @param password The password to be evaluated.
     * @return A string indicating the security level of the password:
     *         "Low security" if entropy is less than 36 bits,
     *         "Medium security" if entropy is between 36 and 59 bits (inclusive),
     *         or "High security" if entropy is 60 bits or more.
     */

    public String entropyScale(String password){
        BigDecimal entropy = bitEntropy(password);
        String returned = "";

        if (entropy.compareTo(BigDecimal.valueOf(36)) < 0) {
            returned = passwordCalculator(password) + " seconds (Low security)";
        } 
        else if (entropy.compareTo(BigDecimal.valueOf(60)) < 0) {
            returned = calculateInYears(password) + " aprox " + " (Medium security)";
        } 
        else {
            returned = "High security (more or less 1,000,000 years)";
        }

        return returned;
    }


        /**
     * Evaluates the security level of a password based on its calculated bit entropy.
     *
     * @param password The password to be evaluated.
     * @return A string indicating the security level of the password:
     *         "Low security" if entropy is less than 36 bits it return character -1,
     *         "Medium security" if entropy is between 36 and 59 bits (inclusive) it returns character 0,
     *         or "High security" if entropy is 60 bits or more it return character 1.
     * 
     * This utility indicates the entropy of a password based on a char value,
     *  which is most useful for use in custom password validation systems.
     */

    public int entropyScaleUtil(String password){
        BigDecimal entropy = bitEntropy(password);
        int entropyInt;
        
        if (entropy.compareTo(BigDecimal.valueOf(36)) < 0) {
            entropyInt = -1; //in seconds 
        } else if(entropy.compareTo(BigDecimal.valueOf(60)) < 0){
            entropyInt = '0'; //
        } else {
            entropyInt = '1';
        }

        return entropyInt;
    }



    public boolean isLeaked(String password) {
        String url = "src/passwordutils/passwords.txt";
        String line = "";
        boolean state = false;

        try(BufferedReader br = new BufferedReader(new FileReader(url))) {
            while ((line = br.readLine()) != null) {
                if (password.equals(line)) {
                    state = true;
                }
            }
        } catch (IOException e) {
           System.err.println(e.getMessage());
        }

        return state;
    }
    

     /**
     * Calculates and return the years it will take
     * for an attack to break the password
     * that will tell how safe it is
     *
     * @param pass the password to analyze
     * @return estimated time in seconds as BigDecimal
     */
    private String calculateInYears(String password){
        BigDecimal yearsToBreak = passwordCalculator(password);
        return TimeUtils.formatYearTime(yearsToBreak);
    }

     /**
     * Calculates and return the date it will take
     * for an attack to break the password
     * that will tell how safe it is
     *
     * @param pass the password to analyze
     * @return estimated time in seconds as BigDecimal
     */
    public String calculateInDate(String password){
        BigDecimal yearsToBreak = passwordCalculator(password);
        return TimeUtils.formatYearTime(yearsToBreak);
    }
    
    
}