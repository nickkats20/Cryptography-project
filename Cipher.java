public class Cipher {
    // fields
    private String plainLetters;
    private String encrypted;
    private String decrypted;

    // constructors
    public Cipher() {
        encrypted = "";
        decrypted = "";
        plainLetters = "abcdefghijklmnopqrstuvwxyz";
    }

    // methods
    public Message encrypt(Message plaintext, int shiftAmount) {
        if (!plaintext.getEncryptionStatus()) {
            String toEncrypt = new String(plaintext.getMessage());
            toEncrypt.toLowerCase();
            for (int i = 0; i < toEncrypt.length(); i++) {
                String letter = toEncrypt.substring(i, i + 1);
                int index = plainLetters.indexOf(letter);
                index += shiftAmount;
                if (index > 25) {
                    index -= 26;
                }
                if (letter.equals(" ")) {
                    encrypted += " ";
                } else {
                    encrypted += plainLetters.substring(index, index + 1);
                }
            }
        } else {
            System.out.println("This text has already been encrypted");
        }
        Message ciphertext = new Message(encrypted, true);
        return ciphertext;
    }

    public Message decrypt(Message plaintext, int amountShifted) {
        if (plaintext.getEncryptionStatus()) {
            String toDecrypt = new String(plaintext.getMessage());
            for (int i = 0; i < toDecrypt.length(); i++) {
                String letter = toDecrypt.substring(i, i + 1);
                int index = plainLetters.indexOf(letter);
                index -= amountShifted;
                if (index < 0) {
                    index += 26;
                }
                if (letter.equals(" ")) {
                    decrypted += " ";
                } else {
                    decrypted += plainLetters.substring(index, index + 1);
                }
            }
        } else {
            System.out.println("This text is not encrypted");
        }
        Message decipheredtext = new Message(decrypted, false);
        return decipheredtext;
    }
}