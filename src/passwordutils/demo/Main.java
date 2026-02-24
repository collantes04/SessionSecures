package passwordutils.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import passwordutils.crypto.HashManager;
import passwordutils.generators.PasswordGenerator;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator ps = new PasswordGenerator();
        Scanner sc = new Scanner(System.in);
        Map<String, User> users = new HashMap<>();

        String user = "";
        String pss = "";

        while (!user.equals(".")) {
            user = sc.nextLine();
            if (user.equals(".")) {
                break;
            }
            String userOp[] = user.split(" ");
            users.putIfAbsent(userOp[0], new User(userOp[0], userOp[1]));
        }


        while (true) {
            try {
                System.out.println("Username: ");
                String uname = sc.nextLine();
                System.out.println("Password: ");
                String pasname = sc.nextLine();

                boolean state = false;

                for (User actualUser : users.values()) {
                    
                    if (actualUser.getUsername().equals(uname) && 
                    HashManager.hashVerify(pasname, actualUser.getPassword())) {
                        state = true;
                        break;
                    } 
                   
                }
                
                if (state) {
                    System.out.println("Login correcto");
                } else {
                    System.out.println(uname + " contraseña o usuario incorrectos");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

    }

}