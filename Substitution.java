// Jeffrey Tso
// 10/9/2024
// CSE 123
// Programming Assignment 0: Ciphers
// Sean Eglip

// Substitution extends the Cipher class to implement its encrypt and decrypt methods
// by substituting each corresponding input character with their own unique output character
// based off a shifter field that can be passed at initialization or set manually.

public class Substitution extends Cipher {
    private String shifter;

    // Constructor method called when no parameters are passed.
    // Initializes shifter (String) with an empty string.
    public Substitution() {
        this.shifter = "";
    }

    // Constructor method called when a shifter (String) is passed.
    // Initializes the shifter field with the passed shifter (String).
    // Throws an IllegalArgumentException if the length of the shifter doesn't match the number 
    // of characters within the cipher's encodable range, the shifter contains a 
    // duplicate character, or if any individual character falls outside the encodable range.
    public Substitution(String shifter) {
        setShifter(shifter);
    }

    // Sets the shifter field to the passed shifter (String).
    // Throws an IllegalArgumentException if the length of the shifter doesn't match the number 
    // of characters within the cipher's encodable range, the shifter contains a 
    // duplicate character, or if any individual character falls outside the encodable range.
    public void setShifter(String shifter) {
        checkShifter(shifter);
        this.shifter = shifter;
    }

    // Takes a shifter (String) as a parameter to be checked for certain conditions.
    // Throws an IllegalArgumentException if the length of the shifter doesn't match the number 
    // of characters within the cipher's encodable range, the shifter contains a 
    // duplicate character, or if any individual character falls outside the encodable range.
    private void checkShifter(String shifter) {
        if (shifter.length() != Cipher.TOTAL_CHARS) {
            throw new IllegalArgumentException("Shifter length should match the" 
                            + " number of characters within the encodable range.");
        }

        for (int i = 0; i < shifter.length() - 1; i++) {
            if (shifter.charAt(i) < Cipher.MIN_CHAR || shifter.charAt(i) > Cipher.MAX_CHAR){
                throw new IllegalArgumentException("Shifter should not contain " + 
                                            "characters outside the encodable range.");
            }
            for (int j = i + 1; j < shifter.length(); j++) {
                if (shifter.charAt(i) == shifter.charAt(j)) {
                    throw new IllegalArgumentException("Shifter should not contain " 
                                                        + "duplicate characters.");
                }
            }
        }

        if (shifter.charAt(shifter.length() - 1) < Cipher.MIN_CHAR || 
            shifter.charAt(shifter.length() - 1) > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException("Shifter should not contain " + 
                                            "characters outside the encodable range.");
        }
    }

    // Behavior: 
    //      - Encrypts an input (String) by substituting each corresponding input 
    //      - character with their own unique output character.
    // Exceptions:
    //      - Throws an IllegalStateException if the shifter field is empty.
    // Return:
    //      - Returns the encrypted string
    // Parameters:
    //      - Takes a String input to be encrypted. The input should be non-null
    //      - and all characters in the input should be within the encodable range.
    public String encrypt(String input) {
        if (shifter == "") {
            throw new IllegalStateException("Shifter was never set.");
        }

        String ret = "";
        for (int i = 0; i < input.length(); i++) {
            ret += shifter.charAt((int) (input.charAt(i)) - Cipher.MIN_CHAR);
        }

        return ret;
    }

    // Behavior: 
    //      - Decrypts an input (String) by substituting each corresponding input 
    //      - character with their own unique output character.
    // Exceptions:
    //      - Throws an IllegalStateException if the shifter field is empty.
    // Return:
    //      - Returns the decrypted string
    // Parameters:
    //      - Takes a String input to be decrypted. The input should be non-null
    //      - and all characters in the input should be within the encodable range.
    public String decrypt(String input) {
        if (shifter == "") {
            throw new IllegalStateException("Shifter was never set.");
        }

        String ret = "";
        for (int i = 0; i < input.length(); i++) {
            ret += (char) (shifter.indexOf( (int) input.charAt(i)) + Cipher.MIN_CHAR);
        }

        return ret;
    }

}