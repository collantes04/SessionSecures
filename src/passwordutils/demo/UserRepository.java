package passwordutils.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import passwordutils.analysis.StrengthTools;

/**
 * Demo class who simulate a Users repository.
 * Uses the EntropyScaleUtil for looks the entropy of a password
 * if the entropy is medium or higher the user is created and load
 * if not, the user isn't create and throws a System error log because the
 * password is so weak
 */
public class UserRepository {
    private Map<String, User> userRepo = new HashMap<>();

    public UserRepository(){
        loadUsers();
    }

    private void loadUsers() {
        String path = "/passwordutils/demo/userRepLoad.csv";
        
        try (InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            
            if (is == null) return;

            String line;
            while ((line = br.readLine()) != null) {
                String[] formatLine = line.split(";");
                if (formatLine.length >= 2) {
                    userRepo.putIfAbsent(formatLine[0], createUser(formatLine[0], formatLine[1]));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private User createUser(String username, String rawPassword) throws NoSuchAlgorithmException, InvalidKeySpecException{
        StrengthTools st = new StrengthTools();
        User us = new User();
        
        /*Here we controls the weakness of the password with the entropy tool
        inside StrengthTools, that analyse the entropy and it is -1 the password isn't
        secure and don't create de user*/
        if (st.entropyScaleUtil(rawPassword) >= 0) { 
            us = new User(username, rawPassword);
        } else {
            System.err.println("The password is so weak, user " + username + " not created");
        }

        return us;
    }

    public User findUserByUsename(String username){
        return userRepo.get(username);
    }

    public Map<String, User> chargeUsers(){
        return userRepo;
    }
}
