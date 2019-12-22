public class Cipher {
    // fields
    // private int shiftAmount;
    private Message plaintext;

    // constructor
    public Cipher(Message plaintext) {
        // this.shiftAmount = shiftAmount;
        this.plaintext = plaintext;
        // normalAlpha();
    }

    // methods
    public String encrypt(int shiftAmount) {
        if (plaintext.getEncryptionStatus() == false) {
            String toEncrypt = new String(plaintext.getMessage());
            String encrypted = new String();
            for (int i = 0; i < toEncrypt.length(); i++) {
                if (Character.isUpperCase(toEncrypt.charAt(i))) {
                    if ((toEncrypt.charAt(i) + shiftAmount) > 'Z') {
                        char ch = (char) (toEncrypt.charAt(i) + shiftAmount - 'Z' + 'A' - 1);
                        encrypted += ch;
                    } else {
                        char ch = (char) (toEncrypt.charAt(i) + shiftAmount);
                        encrypted += ch;
                    }
                }
                if (Character.isLowerCase(toEncrypt.charAt(i))) {
                    if ((toEncrypt.charAt(i) + shiftAmount) > 'z') {
                        char ch = (char) (toEncrypt.charAt(i) + shiftAmount - 'z' + 'a' - 1);
                        encrypted += ch;
                    } else {
                        char ch = (char) (toEncrypt.charAt(i) + shiftAmount);
                        encrypted += ch;

                    }
                }

            }
            return encrypted;
        } else {
            System.out.println("This text has already been encrypted");
        }
        return null;
    }

    public String decrypt(int amountShifted){
        if(plaintext.getEncryptionStatus() == true){
            String toDecrypt = new String(plaintext.getMessage());
            String decrypted = new String();
            for (int i = 0; i < toDecrypt.length(); i++) {
                if (Character.isUpperCase(toDecrypt.charAt(i))) {
                    if ((toDecrypt.charAt(i) - amountShifted) < 'A') {
                        char ch = (char) (toDecrypt.charAt(i) - amountShifted + 'Z' - 'A' + 1);
                        decrypted += ch;
                    } else {
                        char ch = (char) (toDecrypt.charAt(i) - amountShifted);
                        decrypted += ch;
                    }
                }
                if (Character.isLowerCase(toDecrypt.charAt(i))) {
                    if ((toDecrypt.charAt(i) - amountShifted) < 'a') {
                        char ch = (char) (toDecrypt.charAt(i) - amountShifted + 'z' - 'a' + 1);
                        decrypted += ch;
                    } else {
                        char ch = (char) (toDecrypt.charAt(i) - amountShifted);
                        decrypted += ch;

                    }
                }
            }
            return decrypted;
        }else{
            System.out.println("This text is not encrypted");
        }
        return null;
    }
}