import java.util.*;

// Jeffrey Tso
// 10/9/2024
// CSE 123
// Programming Assignment 0: Ciphers
// Sean Eglip

// This class allows for the chaining of multiple Cipher encrypt/decrypt methods by interating
// through a passed list of ciphers and passing their method outputs into the next cipher's method.
public class MultiCipher extends Cipher {
    private List<Cipher> ciphers;

    // This constructor takes a list (List<Cipher>) of ciphers and initializes
    // the ciphers field with the passed list. It throws an IllegalArgumentException
    // if the passed list is null.
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("List should not be null.");
        }
        this.ciphers = ciphers;
    }

    // Behavior:
    //      - Iterates through the ciphers list from 1st to last and takes the output of each 
    //      - cipher's encrypt method and passes it into the next cipher's encrypt method.
    // Return:
    //      - Returns the output of the final cipher's encrypt method.
    // Parameter:
    //      - Takes an input (String) to be encrypted by all the ciphers in the ciphers list.
    public String encrypt (String input) {
        String tempInput = input;
        for (Cipher cipher: ciphers) {
            tempInput = cipher.encrypt(tempInput);
        }
        return tempInput;
    }

    // Behavior:
    //      - Iterates through the ciphers list from last to 1st and takes the output of each 
    //      - cipher's decrypt method and passes it into the next cipher's decrypt method.
    // Return:
    //      - Returns the output of the final cipher's decrypt method.
    // Parameter:
    //      - Takes an input (String) to be decrypted by all the ciphers in the ciphers list.
    public String decrypt (String input) {
        String tempInput = input;
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            tempInput = ciphers.get(i).decrypt(tempInput);
        }
        return tempInput;
    }

}
