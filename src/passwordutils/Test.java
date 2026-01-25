package passwordutils;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        PasswordGenerator gen = new PasswordGenerator();
        Scanner sc = new Scanner(System.in);

       System.out.println(gen.entropyScale(sc.nextLine()));
       System.out.println(gen.entropyScaleUtil(sc.nextLine()));
    }
}