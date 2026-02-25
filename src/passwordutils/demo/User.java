package passwordutils.demo;

import passwordutils.crypto.HashManager;
import passwordutils.crypto.HashResult;

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
