package passwordutils.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import passwordutils.datasources.Symbol;


/**
 * Tools for evaluate the Strength and Entropy of a password
 * @author Jose A. Sánchez
 * @version 1.0
 */
public class StrengthTools {
    private final EntropyUtils entropyTool = new EntropyUtils();


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


    /**
     * Evaluates the security level of a password based on its calculated bit entropy.
     *
     * @param password The password to be evaluated.
     * @return A string indicating the security level of the password:
     *         "Low security" if entropy is less than 36 bits,
     *         "Medium security" if entropy is between 36 and 59 bits (inclusive),
     *         or "High security" if entropy is 60 bits or more.
     * 
     * @apiNote that method is for a visualization mode of entropy, is not
     * a real util method for evaluates, only for visualization
     */
    public String entropyScale(String password){
        BigDecimal entropy = entropyTool.bitEntropy(password);
        String returned = "";

        if (entropy.compareTo(BigDecimal.valueOf(36)) < 0) {
            returned = entropyTool.passwordCalculator(password)
                    + " seconds (Low security)";
        } 
        else if (entropy.compareTo(BigDecimal.valueOf(60)) < 0) {
            returned = entropyTool.calculateInYears(password)
                    + " aprox  (Medium security)";
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
     * @apiNote This utility indicates the entropy of a password based on a char value,
     *  which is most useful for use in custom password validation systems.
     */
    public int entropyScaleUtil(String password){
        BigDecimal entropy = entropyTool.bitEntropy(password);
        int entropyInt;

        if (entropy.compareTo(BigDecimal.valueOf(36)) < 0) {
            entropyInt = -1; //in seconds 
        } else if(entropy.compareTo(BigDecimal.valueOf(60)) < 0){
            entropyInt = 0; //
        } else {
            entropyInt = 1;
        }

        return entropyInt;
    }


    /**
     * 
     * @param password password to look
     * @return false if the password is not weak, true if the password is in the log of weak
     * and common passwords
     * 
     * @apiNote that method is a detector of most common or silly passwords, that method
     * reads passwords.txt and detect passwords like 1234 etc.
     */
    public boolean isLeaked(String password) {

        String path = "/passwordutils/datasources/passwords.txt";
        boolean state = false;

        try (InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            
            if (is == null) {
                System.err.println("Error: No se encontró el archivo de contraseñas en: " + path);
                return false;
            }

            String line;
            while ((line = br.readLine()) != null) {
                if (password.equals(line.trim())) { // .trim() por si hay espacios extra o saltos de línea
                    state = true;
                    break;
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error al acceder a la base de datos de contraseñas: " + e.getMessage());
        }

        return state;
    }

}
