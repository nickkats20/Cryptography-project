import java.util.Arrays;

public class Cipher {
    // fields
    private char[] plainLetters;
    // private char[] plainLettersU;;
    private String encrypted;
    private String decrypted;

    // constructors
    public Cipher(){
        encrypted = "";
        decrypted = "";
        plainLetters = this.letterize();
        // plainLettersU = this.letterizeU();
    }

	// methods
    private char[] letterize() {
        String plainAlphaL = "abcdefghijklmnopqrstuvwxyz";
        char[] plainLettersL = plainAlphaL.toCharArray();
        return plainLettersL;
    }

    // private char[] letterizeU() {
    // String plainAlphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // char[] plainLettersU = plainAlphaU.toCharArray();
    // return plainLettersU;

    // }

    public Message encrypt(Message plaintext, int shiftAmount) {
        if (plaintext.getEncryptionStatus() == false) {
            String toEncrypt = new String(plaintext.getMessage());
            toEncrypt.toLowerCase();
            for (int i = 0; i < toEncrypt.length(); i++) {
                int index = Arrays.binarySearch(plainLetters, toEncrypt.charAt(i));
                index += shiftAmount;
                if (index > 25) {
                    index -= 26;
                }
                encrypted += plainLetters[index];
                // } else if (Character.isUpperCase(toEncrypt.charAt(i))) {
                // int index = Arrays.binarySearch(plainLettersU, toEncrypt.charAt(i));
                // index += shiftAmount;
                // if (index > 25) {
                // index -= 26;
                // }
                // encrypted += plainLettersU[index];
            }

        } else {
            System.out.println("This text has already been encrypted");
        }
        Message encryptedMessage = new Message(encrypted, true);
        return encryptedMessage;
    }

    public Message decrypt(Message plaintext, int amountShifted) {
        if (plaintext.getEncryptionStatus() == true) {
            String toDecrypt = new String(plaintext.getMessage());
            for (int i = 0; i < toDecrypt.length(); i++) {

                int index = Arrays.binarySearch(plainLetters, toDecrypt.charAt(i));
                index -= amountShifted;
                if (index < 0) {
                    index += 26;
                }
                decrypted += plainLetters[index];
                // } else if (Character.isUpperCase(toDecrypt.charAt(i))) {
                // int index = Arrays.binarySearch(plainLettersU, toDecrypt.charAt(i));
                // index -= amountShifted;
                // if (index < 0) {
                // index += 26;
                // }
                // decrypted += plainLettersU[index];

            }
        } else {
            System.out.println("This text is not encrypted");
        }
        Message decryptedMessage = new Message(decrypted, false);
        return decryptedMessage;
    }

    public String accessMessage(Message decryptedMessage) {
        return decryptedMessage.getMessage();
    }
}