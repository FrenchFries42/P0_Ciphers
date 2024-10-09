// Jeffrey Tso
// 10/9/2024
// CSE 123
// Programming Assignment 0: Ciphers
// Sean Eglip

// CaesarKey creates a specific type of shifter given a key to be used in substitution's encrypt 
// and decrypt methods. The shifter is created by placing a key at the front of the shifter, with
// the rest of the alphabet following normally.

public class CaesarKey extends Substitution {

    // Behavior:
    //      - This constructor creates a shifter and sets substitution's shifter to it based 
    //      - on the following: a key is placed at the front of the shifter, with the 
    //      - rest of the alphabet following normally (minus the characters included in the key).
    // Exceptions:
    //      - Throws an IllegalArgumentException if the key is empty, contains a duplicate 
    //      - character, or if any individual character falls outside the encodable range.
    // Parameter:
    //      - Takes in a key (String) to be used in creating the shfiter.
    public CaesarKey(String key) {
        if (key.length() == 0) {
            throw new IllegalArgumentException("Key should not be empty.");
        }

        for (int i = 0; i < key.length() - 1; i++) {
            if (key.charAt(i) < Cipher.MIN_CHAR || key.charAt(i) > Cipher.MAX_CHAR){
                throw new IllegalArgumentException("Key should not contain characters outside the encodable range.");
            }
            for (int j = i + 1; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j)) {
                    throw new IllegalArgumentException("Key should not contain duplicate characters.");
                }
            }
        }

        if (key.charAt(key.length() - 1) < Cipher.MIN_CHAR || key.charAt(key.length() - 1) > Cipher.MAX_CHAR) {
            throw new IllegalArgumentException("key should not contain characters outside the encodable range.");
        }

        String shifter = key;

        for (int i = Cipher.MIN_CHAR; i <= Cipher.MAX_CHAR; i++) {
            if (key.indexOf((char) i) == -1) {
                shifter += (char) i;
            }
        }

        super.setShifter(shifter);
    }

}