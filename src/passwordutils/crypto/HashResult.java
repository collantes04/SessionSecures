package passwordutils.crypto;

import java.util.Base64;

public class HashResult {
    private byte[] hash;
    private byte[] salt;
    private int iterations;

    protected HashResult(byte[] hash, byte[] salt, int it){
        this.hash = hash;
        this.salt = salt;
        this.iterations = it;
    }

    public String getHash() {
        return Base64.getEncoder().encodeToString(hash);
    }
    public int getIterations() {
        return iterations;
    }
    public String getSalt() {
        return Base64.getEncoder().encodeToString(salt);
    }

    @Override
    public String toString() {
        return "salt= "+ getSalt() + "\nhash = " + getHash() + "\niterations = "+this.iterations;
    }
}
