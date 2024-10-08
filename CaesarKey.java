public class CaesarKey extends Substitution {

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