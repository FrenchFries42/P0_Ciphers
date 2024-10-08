public class Substitution extends Cipher {
    private String shifter;

    public Substitution() {
        this.shifter = "";
    }

    public Substitution(String shifter) {
        if (shifter.length() != Cipher.TOTAL_CHARS) {
            throw new IllegalArgumentException("Shifter length should match the number of characters within the encodable range.");
        }

        for (int i = 0; i < shifter.length() - 1; i++) {
            if (shifter.charAt(i) < Cipher.MIN_CHAR || shifter.charAt(i) > Cipher.MAX_CHAR){
                throw new IllegalArgumentException("Shifter should not contain characters outside the encodable range.");
            }
            for (int j = i + 1; j < shifter.length(); j++) {
                if (shifter.charAt(i) == shifter.charAt(j)) {
                    throw new IllegalArgumentException("Shifter should not contain duplicate characters.");
                }
            }
        }

        if (shifter.charAt(shifter.length() - 1) < Cipher.MIN_CHAR || shifter.charAt(shifter.length() - 1) > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException("Shifter should not contain characters outside the encodable range.");
        }

        this.shifter = shifter;
    }

    public void setShifter(String shifter) {
        if (shifter.length() != Cipher.TOTAL_CHARS) {
            throw new IllegalArgumentException("Shifter length should match the number of characters within the encodable range.");
        }

        for (int i = 0; i < shifter.length() - 1; i++) {
            if (shifter.charAt(i) < Cipher.MIN_CHAR || shifter.charAt(i) > Cipher.MAX_CHAR){
                throw new IllegalArgumentException("Shifter should not contain characters outside the encodable range.");
            }
            for (int j = i + 1; j < shifter.length(); j++) {
                if (shifter.charAt(i) == shifter.charAt(j)) {
                    throw new IllegalArgumentException("Shifter should not contain duplicate characters.");
                }
            }
        }

        if (shifter.charAt(shifter.length() - 1) < Cipher.MIN_CHAR || shifter.charAt(shifter.length() - 1) > Cipher.MAX_CHAR) {
                throw new IllegalArgumentException("Shifter should not contain characters outside the encodable range.");
        }

        this.shifter = shifter;
    }

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