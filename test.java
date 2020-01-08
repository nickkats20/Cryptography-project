public class test {
    public static void main(String[] args) {
        //encryption test
        Message m1 = new Message("hello everyone", false);
        System.out.println(m1.getMessage());
        System.out.println(m1.getEncryptionStatus());
        Cipher c1 = new Cipher();
        System.out.println(c1.encrypt(m1, 3).getMessage());
       
        System.out.println("********************");

        //decryption test
        Message m2 = new Message("khoor hyhubrqh", true);
        System.out.println(m2.getMessage());
        System.out.println(m2.getEncryptionStatus());
        Cipher c2 = new Cipher();
        System.out.println(c2.decrypt(m2, 3).getMessage());
    }
}
