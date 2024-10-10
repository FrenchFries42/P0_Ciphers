import java.util.*;

// Jeffrey Tso
// 10/9/2024
// CSE 123
// Programming Assignment 0: Ciphers
// Sean Eglip

// Given a 'shift' integer, CaesarShift, a subclass of Substitution, creates a specific 
// type of shifter to be used in Substitution's encrpyt and decrypt methods. The shifter 
// is created by moving all characters within the encodable range to the left 'shift' amount 
// of times, moving the value at the front to the end each time.

public class CaesarShift extends Substitution {

    // Behavior:
    //      - This constructor creates a shifter and sets substitution's shifter to it.
    //      - The shifter is created by moving all characters within the encodable range 
    //      - a certain amount of times, with that being determined by a passed 'shift' parameter.
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