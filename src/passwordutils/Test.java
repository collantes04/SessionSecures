package passwordutils;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        PasswordGenerator gen = new PasswordGenerator();
        Scanner sc = new Scanner(System.in);

        

        /*if (gen.isLeaked(sc.nextLine())) {
            System.out.println("IS LEAKED");
        } else {
            System.out.println("Not leaked");
        }*/

       System.out.println(gen.entropyScale(sc.nextLine()));
       System.out.println(gen.entropyScaleUtil(sc.nextLine()));
    }
}