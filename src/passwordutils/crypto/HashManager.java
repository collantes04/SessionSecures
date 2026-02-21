package passwordutils.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashManager {
    private final SecureRandom sr = new SecureRandom();
    /**
     * Generates a Hash code for a password 
     *
     * @param password The password to be hashed.
     * @return A object Hash Result
     * @apiNote That object must be used with a try-catch because it throw NoSuchAlgorithmException
     * and throw InvalidKeySpecException
     */

    public HashResult generateHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        SaltManager sm = new SaltManager();
        byte saltBytes[] = sm.generateSalt(32);
        int iterations = 200000;

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes,iterations, 256);

        SecretKeyFactory sf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        byte hash[] = sf.generateSecret(spec).getEncoded();
        Arrays.fill(password.toCharArray(), '\0');
        
        return new HashResult(hash, saltBytes, iterations);
    }
}
