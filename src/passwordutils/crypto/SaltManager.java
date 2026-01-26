package passwordutils.crypto;

import java.security.SecureRandom;

public class SaltManager {
    protected final SecureRandom sr = new SecureRandom();

    protected byte[] generateSalt(int len) {
        byte bytesArr[] = new byte[len];
        
        sr.nextBytes(bytesArr);

        return bytesArr;
    }
}
