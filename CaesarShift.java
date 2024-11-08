import java.util.*;

// Jeffrey Tso
// 10/9/2024
// CSE 123
// Programming Assignment 0: Ciphers
// Sean Eglip

// CaesarShift, a subclass of Substitution, creates a specific 
// type of shifter to be used in Substitution's encrpyt and decrypt methods.

public class CaesarShift extends Substitution {

    // Behavior:
    //      - This constructor creates a CaesarShift cipher to change each of an input's
    //      - characters to a specific shifter. The shifter is created by moving all characters
    //      - within the encodable range a certain amount of times.
    // Exceptions:
    //      - Throws an IllegalArgumentException if the shift value is less than or equal to 0.
    // Parameter:
    //      - Takes a shift (int) value.
    public CaesarShift(int shift) {
        if (shift <= 0) {
            throw new IllegalArgumentException("The shift value must be greater than 0.");
        }

        Queue<Character> queue = new LinkedList<>();

        for (int i = Cipher.MIN_CHAR; i <= Cipher.MAX_CHAR; i++) {
            queue.add((char) i);
        }

        for (int i = 0; i < shift; i++) {
            queue.add(queue.remove());
        }

        String shifter = "";

        while (queue.size() != 0) {
            shifter += queue.remove();
        }

        super.setShifter(shifter);
    }
    
}