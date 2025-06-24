package passwordgenerator;

public class Test {
    public static void main(String[] args) {
        PasswordGenerator gen = new PasswordGenerator();

        System.out.println(gen.generatorPassword(8));

        /*String tiempoTotal = TimeUtils.formatYearTime(gen.passwordCalculator("1234"));
        System.out.println(tiempoTotal);*/
    }
}
