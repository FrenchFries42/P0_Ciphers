import java.util.*;

public class MultiCipher extends Cipher {
    private List<Cipher> ciphers;

    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("List should not be null.");
        }
        this.ciphers = ciphers;
    }

    public String encrypt (String input) {
        String tempInput = input;
        for (Cipher cipher: ciphers) {
            tempInput = cipher.encrypt(tempInput);
        }
        return tempInput;
    }

    public String decrypt (String input) {
        String tempInput = input;
        for (Cipher cipher: ciphers) {
            tempInput = cipher.decrypt(tempInput);
        }
        return tempInput;
    }

}
