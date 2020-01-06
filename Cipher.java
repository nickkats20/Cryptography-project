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
        if (plaintext.getEncryptionStatus() == false) {
            String toEncrypt = new String(plaintext.getMessage());
            toEncrypt.toLowerCase();
            for (int i = 0; i < toEncrypt.length(); i++) {
                String letter = toEncrypt.substring(i, i + 1);
                int index = plainLetters.indexOf(letter);
                index += shiftAmount;
                if (index > 25) {
                    index -= 26;
                }
                encrypted += plainLetters.substring(index, index + 1);
            }
        } else {
            System.out.println("This text has already been encrypted");
        }
        Message encryptedMessage = new Message(encrypted, true);
        System.out.println(encryptedMessage.getMessage());
        return encryptedMessage;
    }

    public Message decrypt(Message plaintext, int amountShifted) {
        if (plaintext.getEncryptionStatus() == true) {
            String toDecrypt = new String(plaintext.getMessage());
            for (int i = 0; i < toDecrypt.length(); i++) {
                String letter = toDecrypt.substring(i, i + 1);
                int index = plainLetters.indexOf(letter);
                index -= amountShifted;
                if (index < 0) {
                    index += 26;
                }
                decrypted += plainLetters.substring(index, index + 1);
            }
        } else {
            System.out.println("This text is not encrypted");
        }
        Message decryptedMessage = new Message(decrypted, false);
        System.out.println(decryptedMessage.getMessage());
        return decryptedMessage;
    }
}