public class test {
    public static void main(String[] args) {
        Message m1 = new Message("abc", false);
        System.out.println(m1.getMessage());
        Cipher c1 = new Cipher(m1);
        System.out.println(c1.encrypt(3));

    }
}
/*
 * take a string, convert it into a char array take the elememt in array at
 * index 1 (first letter in string to be encrypted) determine what the index of
 * this element is in the alphabet replace the first element in array with the
 * alphabet + x element
 * 
 */
