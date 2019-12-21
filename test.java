public class test{
    public static void main(String[] args) {
        Message m1 = new Message("Hello world", false);
        System.out.println(m1.getEncryptionStatus());
        System.out.println(m1.getMessage());
    }
}