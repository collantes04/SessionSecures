package passwordutils.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class HashManager {
    private final SecureRandom sr = new SecureRandom();
    
    /**
     * That static method generate a Hash code for a password for first time and save in HashResult object.
     *
     * @param password The password to be hashed.
     * @return A object HashResult
     * @apiNote That method must be used with a try-catch because it throw NoSuchAlgorithmException
     * and throw InvalidKeySpecException
     */

    public static HashResult generateHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        SaltManager sm = new SaltManager();
        byte saltBytes[] = sm.generateSalt(32);
        int iterations = 200000;
        char passwordChar[] = password.toCharArray();

        /*PBEKeySpec derive the key to 256 bits and the required iterations for more security */
        PBEKeySpec spec = new PBEKeySpec(passwordChar, saltBytes,iterations, 256);
        Arrays.fill(passwordChar, '\0'); //that cleans the array used in memory for more security
        
        /*Execute the PBKDF2 algorithm with the encoded required*/
        SecretKeyFactory sf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        /*Mix the password and the salt the number of times the iterations require, and gives a 256 bit hashs,
        the hash and salt will be encoded in the HashResult object not here, here you obtain the arraybit hash*/

        byte hash[] = sf.generateSecret(spec).getEncoded();
        
        return new HashResult(hash, saltBytes, iterations);
    }

    /**
     * That static method verify if a login password matches with the hash previously generated
     * by the password that params has been saved in the object HashResult.
     * 
     * @param password the password that has been entered in the login 
     * @param hashResult object hashResult that has been build in the first
     * register of one user and is in the database.
     * That object contains the raw hash, raw salt and iterations.
     * @return true if the password hash coding is the same, false if not is
     * @apiNote That method must be used with a try-catch because it throw NoSuchAlgorithmException
     * and throw InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */

    public static boolean hashVerify(String password, HashResult userPassSession) throws NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] rawSalt = userPassSession.getSaltArr();
        byte[] rawHash = userPassSession.getHashArr();
        int iterations = userPassSession.getIterations();

        /*We repeat the encode byte process to obtain a Hash from the password attemp to log-in */
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), rawSalt, iterations, rawHash.length*8); 
        /* *8 because PBEKeySpec needs bit not bytes */

        SecretKeyFactory sf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] testHash = sf.generateSecret(spec).getEncoded();
        
        //Compare the saved hash with the newly calculated hash securely against timing attacks.
        return java.security.MessageDigest.isEqual(rawHash, testHash);

    }
}