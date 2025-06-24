package passwordgenerator.generators;

import java.util.Random;

public enum Symbol {
    AT_SIGN(0, "@"),
    EXCLAMATION_MARK(1, "!"),
    HASH(2, "#"),
    DOLLAR(3, "$"),
    PERCENT(4, "%"),
    CARET(5, "^"),
    AMPERSAND(6, "&"),
    ASTERISK(7, "*"),
    LEFT_PARENTHESIS(8, "("),
    RIGHT_PARENTHESIS(9, ")"),
    UNDERSCORE(10, "_"),
    PLUS(11, "+"),
    MINUS(12, "-"),
    EQUALS(13, "="),
    LEFT_BRACE(14, "{"),
    RIGHT_BRACE(15, "}"),
    LEFT_BRACKET(16, "["),
    RIGHT_BRACKET(17, "]"),
    PIPE(18, "|"),
    BACKSLASH(19, "\\"),
    COLON(20, ":"),
    SEMICOLON(21, ";"),
    SINGLE_QUOTE(22, "'"),
    LESS_THAN(23, "<"),
    GREATER_THAN(24, ">"),
    COMMA(25, ","),
    PERIOD(26, "."),
    QUESTION_MARK(27, "?"),
    SLASH(28, "/");
    
    private static final Random RAND = new Random();
    private String symbol;
    private int key;

    private Symbol(int key, String symbol){
        this.key = key;
        this.symbol = symbol;
    }

    public static String retSymbol(){
        int key = RAND.nextInt(29);
        String returnedSym = "";

        for (Symbol sym : Symbol.values()) {
            if (sym.getKey() == key) {
                returnedSym = sym.getSymbol();
            }
        }
        return returnedSym;
    }

    public int getKey() {
        return key;
    }

    public String getSymbol() {
        return symbol;
    }

}
