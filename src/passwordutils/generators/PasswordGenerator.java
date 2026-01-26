package passwordutils.generators;

import java.security.SecureRandom;
import java.util.Random;

import passwordutils.datasources.LowercaseLetter;
import passwordutils.datasources.Symbol;
import passwordutils.datasources.UppercaseLetter;

public class PasswordGenerator implements InterfaceRandGen{
    
    public String generatorPassword(){

    /**
     * This method generates a random password
     * from any parameter beacause is a random length and returns the password
     * the limits of length are [16, 40] characters, 16 is the secure min and
     * 40 is a good max limit of lenght.
     */

        SecureRandom rand = new SecureRandom();
        int election;
        int len = rand.nextInt(25)+16;
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
}
