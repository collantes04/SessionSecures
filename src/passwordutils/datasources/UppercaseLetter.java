package passwordutils.datasources;

import java.security.SecureRandom;

import passwordutils.datasources.UppercaseLetter;

/**
 * Uppercase util for password generator
 * @author Jose A. Sánchez
 * @version 1.0
 */
public enum UppercaseLetter {
    A(0, "A"),
    B(1, "B"),
    C(2, "C"),
    D(3, "D"),
    E(4, "E"),
    F(5, "F"),
    G(6, "G"),
    H(7, "H"),
    I(8, "I"),
    J(9, "J"),
    K(10, "K"),
    L(11, "L"),
    M(12, "M"),
    N(13, "N"),
    O(14, "O"),
    P(15, "P"),
    Q(16, "Q"),
    R(17, "R"),
    S(18, "S"),
    T(19, "T"),
    U(20, "U"),
    V(21, "V"),
    W(22, "W"),
    X(23, "X"),
    Y(24, "Y"),
    Z(25, "Z");

    private static final SecureRandom RAND = new SecureRandom();
    private int key;
    private String letter;

    private UppercaseLetter(int key, String letter){
        this.key = key;
        this.letter = letter;
    }

    public static String upperRet(){
        int key;
        String retLetter = "";

        key = RAND.nextInt(26);

        for (UppercaseLetter letter : UppercaseLetter.values()) {
            if (letter.getKey() == key) {
                retLetter = letter.getLetter();
            }
        }
        return retLetter;
    }

    public int getKey() {
        return key;
    }

    public String getLetter() {
        return letter;
    }
}
