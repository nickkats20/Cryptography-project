public class test {
    public static void main(String[] args) {
        Message m1 = new Message("abc", false);
        System.out.println(m1.getMessage());
        System.out.println(m1.getEncryptionStatus());
        Cipher c1 = new Cipher();
        System.out.println(c1.encrypt(m1, 3));
    }
}
