package passwordutils.crypto;

import java.security.SecureRandom;

public class SaltManager {
    protected final SecureRandom sr = new SecureRandom();
    /**
     * Generate a salt
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
