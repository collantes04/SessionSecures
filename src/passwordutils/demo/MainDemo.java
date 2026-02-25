package passwordutils.demo;

import java.util.Map;
import java.util.Scanner;

import passwordutils.analysis.StrengthTools;
import passwordutils.crypto.HashManager;
import passwordutils.crypto.HashResult;


/**
 * Excutable for the demo of crypto sources and analysis sources
 * applicated for a session login (with a local repository) and
 * a session register (looks the entropy of a password for create a user or not)
 * @author Jose A. Sánchez
 * @version 1.0
 */
public class MainDemo {

    public static void main(String[] args) {
        UserRepository usRepo = new UserRepository();
        Map<String, User> repositoryBackup = usRepo.chargeUsers();
        StrengthTools st = new StrengthTools();

        User us = new User();

        /*Login simulation */
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Welcome to demo class of SessionSecures");
            System.out.println("Put '.' to end the demo execution");
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
