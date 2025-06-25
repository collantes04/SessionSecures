package passwordutils;

public class Test {
    public static void main(String[] args) {
        PasswordGenerator gen = new PasswordGenerator();

        String pass = gen.generatorPassword(16);
        System.out.println(pass);
        System.out.println(gen.entropyScale(pass));
    }
}
