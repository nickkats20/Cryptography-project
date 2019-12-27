import java.util.Arrays;

public class Cipher {
    // fields
    private Message plaintext;
    private char[] plainLettersL;
    private char[] plainLettersU;;
    private String encrypted;
    private String decrypted;

    // constructors
    public Cipher(Message plaintext) {
        this.plaintext = plaintext;
        encrypted = "";
        decrypted = "";
        plainLettersL = this.letterizeL();
        plainLettersU = this.letterizeU();
    }

    // methods
    private char[] letterizeL() {
        String plainAlphaL = "abcdefghijklmnopqrstuvwxyz";
        char[] plainLettersL = plainAlphaL.toCharArray();
        return plainLettersL;
    }

    private char[] letterizeU() {
        String plainAlphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] plainLettersU = plainAlphaU.toCharArray();
        return plainLettersU;

    }

    public String encrypt(int shiftAmount) {
        if (plaintext.getEncryptionStatus() == false) {
            String toEncrypt = new String(plaintext.getMessage());
            for (int i = 0; i < toEncrypt.length(); i++) {
                if (Character.isLowerCase(toEncrypt.charAt(i))) {
                    int index = Arrays.binarySearch(plainLettersL, toEncrypt.charAt(i));
                    index += shiftAmount;
                    if (index > 25) {
                        index -= 26;
                    }
                    encrypted += plainLettersL[index];
                } else if (Character.isUpperCase(toEncrypt.charAt(i))) {
                    int index = Arrays.binarySearch(plainLettersU, toEncrypt.charAt(i));
                    index += shiftAmount;
                    if (index > 25) {
                        index -= 26;
                    }
                    encrypted += plainLettersU[index];
                }
            }
        } else {
            System.out.println("This text has already been encrypted");
        }
        plaintext.setEncryptionStatus(true);
        return encrypted;
    }

    public String decrypt(int amountShifted) {
        if (plaintext.getEncryptionStatus() == true) {
            String toDecrypt = new String(plaintext.getMessage());
            for (int i = 0; i < toDecrypt.length(); i++) {
                if (Character.isLowerCase(toDecrypt.charAt(i))) {
                    int index = Arrays.binarySearch(plainLettersL, toDecrypt.charAt(i));
                    index -= amountShifted;
                    if (index < 0) {
                        index += 26;
                    }
                    decrypted += plainLettersL[index];
                } else if (Character.isUpperCase(toDecrypt.charAt(i))) {
                    int index = Arrays.binarySearch(plainLettersU, toDecrypt.charAt(i));
                    index -= amountShifted;
                    if (index < 0) {
                        index += 26;
                    }
                    decrypted += plainLettersU[index];
                }
            }
        } else {
            System.out.println("This text is not encrypted");
        }
        plaintext.setEncryptionStatus(false);
        return decrypted;
    }

    // public String encrypt(int shiftAmount) {
    // if (plaintext.getEncryptionStatus() == false) {
    // String toEncrypt = new String(plaintext.getMessage());
    // String encrypted = new String();
    // for (int i = 0; i < toEncrypt.length(); i++) {
    // if (Character.isUpperCase(toEncrypt.charAt(i))) {
    // if ((toEncrypt.charAt(i) + shiftAmount) > 'Z') {
    // char ch = (char) (toEncrypt.charAt(i) + shiftAmount - 'Z' + 'A' - 1);
    // encrypted += ch;
    // } else {
    // char ch = (char) (toEncrypt.charAt(i) + shiftAmount);
    // encrypted += ch;
    // }
    // }
    // if (Character.isLowerCase(toEncrypt.charAt(i))) {
    // if ((toEncrypt.charAt(i) + shiftAmount) > 'z') {
    // char ch = (char) (toEncrypt.charAt(i) + shiftAmount - 'z' + 'a' - 1);
    // encrypted += ch;
    // } else {
    // char ch = (char) (toEncrypt.charAt(i) + shiftAmount);
    // encrypted += ch;
    // }
    // }

    // }
    // plaintext.setEncryptionStatus(true);
    // return encrypted;
    // } else {
    // System.out.println("This text has already been encrypted");
    // }
    // return null;
    // }

    // public String decrypt(int amountShifted){
    // if(plaintext.getEncryptionStatus() == true){
    // String toDecrypt = new String(plaintext.getMessage());
    // String decrypted = new String();
    // for (int i = 0; i < toDecrypt.length(); i++) {
    // if (Character.isUpperCase(toDecrypt.charAt(i))) {
    // if ((toDecrypt.charAt(i) - amountShifted) < 'A') {
    // char ch = (char) (toDecrypt.charAt(i) - amountShifted + 'Z' - 'A' + 1);
    // decrypted += ch;
    // } else {
    // char ch = (char) (toDecrypt.charAt(i) - amountShifted);
    // decrypted += ch;
    // }
    // }
    // if (Character.isLowerCase(toDecrypt.charAt(i))) {
    // if ((toDecrypt.charAt(i) - amountShifted) < 'a') {
    // char ch = (char) (toDecrypt.charAt(i) - amountShifted + 'z' - 'a' + 1);
    // decrypted += ch;
    // } else {
    // char ch = (char) (toDecrypt.charAt(i) - amountShifted);
    // decrypted += ch;
    // }
    // }
    // }
    // plaintext.setEncryptionStatus(false);
    // return decrypted;
    // }else{
    // System.out.println("This text is not encrypted");
    // }
    // return null;
    // }
}