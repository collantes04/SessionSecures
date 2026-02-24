package passwordutils.crypto;

import java.security.SecureRandom;

public class SaltManager {
    protected final SecureRandom sr = new SecureRandom();
    /**
     * Generate a random salt, the salt prevents two users have the same hash.
     * That prevents the rainbow tables to.
     *
     * @param len Lenght for the salt (recommended 16 or 32 bits)
     * @return Salt array
     * 
     */

    protected byte[] generateSalt(int len) {
        byte bytesArr[] = new byte[len];
        
        sr.nextBytes(bytesArr);

        return bytesArr;
    }
}
