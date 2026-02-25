package passwordutils.demo;

import passwordutils.crypto.HashManager;
import passwordutils.crypto.HashResult;

/**
 * Demo class who simulated a User object.
 * Use the HashManager method for turn the password with a salt
 * into hashed password and save salt, iterations and hash in a HashResult object
 */
public class User {
    private HashResult password;
    private String username;

    public User(String username, String passw){
        try {
            this.username = username;
            this.password = HashManager.generateHash(passw);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public User(){
        
    }

    public HashResult getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Username: " + getUsername() + "\n" + "Password: " + getPassword().getHash();
    }
}
