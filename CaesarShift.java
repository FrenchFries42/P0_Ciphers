public class CaesarShift extends Substitution {

    public CaesarShift(int shift) {
        if (shift <= 0) {
            throw new IllegalArgumentException("The shift value must be greater than 0.");
        }

        String shifter = "";
        for (int i = Cipher.MIN_CHAR + shift; i <= Cipher.MAX_CHAR; i++) {
            shifter += (char) i;
        }

        for (int j = Cipher.MIN_CHAR; j < Cipher.MIN_CHAR + shift; j++) {
            shifter += (char) j;
        }

        super.setShifter(shifter);
    }
    
}