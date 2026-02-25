package passwordutils.demo;

import java.util.Map;
import java.util.Scanner;

import passwordutils.analysis.StrengthUtils;
import passwordutils.crypto.HashManager;
import passwordutils.crypto.HashResult;

public class Session {

    public static void main(String[] args) {
        UserRepository usRepo = new UserRepository();
        Map<String, User> repositoryBackup = usRepo.chargeUsers();
        StrengthUtils st = new StrengthUtils();

        User us = new User();

        /*Login simulation */
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Welcome to demo class of SessionSecures");
            System.out.println("Put . to end the demo execution");
            System.out.print("Username: ");
            String usename = scan.nextLine();
            if (usename.equals(".")) {
                break;
            }

            us = usRepo.findUserByUsename(usename);
            if (us != null) {
                System.out.print("Password: ");
                String password = scan.nextLine();
                /*We use HashResult to obtain full params of the
                password saved, and can we compare the password login
                with the saved using HashManager static methods*/
                HashResult hs = us.getPassword(); 
                try {
                    if (HashManager.hashVerify(password, hs)) {
                        System.out.println("Login sucessfully with " + us.getUsername());
                        System.out.println(us.toString());
                    } else {
                        System.out.println("Password don't mismatch, is wrong");
                    }

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println("The user don't exists");
            }
        }
        
    }
}
