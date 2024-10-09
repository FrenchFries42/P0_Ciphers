import java.util.*;

public class CaesarShift extends Substitution {

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