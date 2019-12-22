public class Cipher {
    // fields
    // private int shiftAmount;
    private Message plaintext;
    private char[] normAlphaL = new char[26];

    // constructor
    public Cipher(Message plaintext) {
        // this.shiftAmount = shiftAmount;
        this.plaintext = plaintext;
        normalAlpha();
    }

    // methods

    private void normalAlpha() {
        int index = 0;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            normAlphaL[index] = letter;
            index++;
        }
    }

    public char[] encrypt(int shiftAmount) {
        String toEncrypt = new String(plaintext.getMessage());
        char[] comparator = toEncrypt.toCharArray();
        int index = 0;
        while (index < comparator.length) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (comparator[index] == ch) {
                    comparator[index] = (char) (ch + shiftAmount);
                    index++;
                }
            }

        }
        return comparator;

        // int i = 0;
        // while (comparator[i] <= comparator.length) {
        // for (int j = 0; j < normAlphaL.length; j++) {
        // if (comparator[i] == normAlphaL[j]) {
        // comparator[i] = normAlphaL[j + shiftAmount];
        // }

        // }
        // }
        // String encrypted = new String(comparator);
        // return encrypted;
    }
}