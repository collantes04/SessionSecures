package passwordutils.generators;

import java.security.SecureRandom;
import java.util.StringJoiner;

import passwordutils.datasources.Dictionary;

/**
 * Generate a PassPhrased password with a determinated length
 * @apiNote The lenght must be higher or equal to 5
 * @author Jose A. Sánchez
 * @version 1.0
 */
public class PassphrasedGenerator implements InterfaceRanPassPhrased{
    private SecureRandom sr = new SecureRandom();
    /**
     * Generates a passphrased password in a 5 or higher len
     * @param len
     * @return passphrased password
     */
    @Override
    public String phraseGenerator(long len) {
        if (len < 5) {
            throw new IllegalArgumentException("La longitud debe ser al menos 5 palabras.");
        }

        StringJoiner sj = new StringJoiner("-");
        
        for (int i = 0; i < len; i++) {
            sj.add(Dictionary.getRandomWord());
        }
        
        return sj.toString();
    }

    /**
     * Generates a passphrased password in a random lenght between 5 or 10
     */
    @Override
    public String phraseGenerator() {
        long randomLen = sr.nextInt(6) + 5; 
        return phraseGenerator(randomLen);
    }

    }

    
