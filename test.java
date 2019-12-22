public class test {
    public static void main(String[] args) {
        Message m1 = new Message("Weet cehdydw vqc", true);
        System.out.println(m1.getMessage());
        Cipher c1 = new Cipher(m1);
        System.out.println(c1.decrypt(16));  
    }
}
