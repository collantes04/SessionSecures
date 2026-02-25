package passwordutils.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import passwordutils.analysis.StrengthUtils;

public class UserRepository {
    private Map<String, User> userRepo = new HashMap<>();

    public UserRepository(){
        loadUsers();
    }

    private void loadUsers(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/passwordutils/demo/userRepLoad.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String formatLine[] = line.split(";");
                userRepo.putIfAbsent(formatLine[0], createUser(formatLine[0], formatLine[1]));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private User createUser(String username, String rawPassword) throws NoSuchAlgorithmException, InvalidKeySpecException{
        StrengthUtils st = new StrengthUtils();
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
