package passwordutils.crypto;

import java.util.Base64;

/**
 * That object saves hash, salt and iterations of a previously encoded 
 * password with HashManager. That object can will be integrate in a user object
 * to facilitate the login security protocol
 */

public class HashResult {
    
    private byte[] hash;
    private byte[] salt;
    private int iterations;

    protected HashResult(byte[] hash, byte[] salt, int it){
        this.hash = hash;
        this.salt = salt;
        this.iterations = it;
    }

    /**
     *  
     * @return encoded Hash in B64
     */
    public String getHash() {
        return Base64.getEncoder().encodeToString(hash);
    }

    public int getIterations() {
        return iterations;
    }

     /**
     *  
     * @return encoded Salt in B64
     */

    public String getSalt() {
        return Base64.getEncoder().encodeToString(salt);
    }


    /**
     * 
     * @return raw salt byte array
     */
    public byte[] getSaltArr(){
        return salt;
    }

    
    /**
     * 
     * @return raw hash byte array
     */
    public byte[] getHashArr(){
        return hash;
    }

    @Override
    public String toString() {
        return "salt= "+ getSalt() + "\nhash = " + getHash() + "\niterations = "+this.iterations;
    }
}
