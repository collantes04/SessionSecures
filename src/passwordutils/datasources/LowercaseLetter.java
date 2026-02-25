package passwordutils.datasources;

import java.security.SecureRandom;

import passwordutils.datasources.LowercaseLetter;

/**
 * Lowercase util for password generator
 * @author Jose A. Sánchez
 * @version 1.0
 */
public enum LowercaseLetter {
    a(0, "a"),
    b(1, "b"),
    c(2, "c"),
    d(3, "d"),
    e(4, "e"),
    f(5, "f"),
    g(6, "g"),
    h(7, "h"),
    i(8, "i"),
    j(9, "j"),
    k(10, "k"),
    l(11, "l"),
    m(12, "m"),
    n(13, "n"),
    o(14, "o"),
    p(15, "p"),
    q(16, "q"),
    r(17, "r"),
    s(18, "s"),
    t(19, "t"),
    u(20, "u"),
    v(21, "v"),
    w(22, "w"),
    x(23, "x"),
    y(24, "y"),
    z(25, "z");

    private static final SecureRandom RAND = new SecureRandom();
    private int key;
    private String letter;

    private LowercaseLetter(int key, String letter){
        this.key = key;
        this.letter = letter;
    }

    public static String lowerRet(){
        int key = RAND.nextInt(26);
        String retLower = "";

        for (LowercaseLetter letter : LowercaseLetter.values()) {
            if (letter.getKey() == key) {
                retLower = letter.getLetter();
            }
        }

        return retLower;
    }

    public int getKey() {
        return key;
    }

    public String getLetter() {
        return letter;
    }

    
}
