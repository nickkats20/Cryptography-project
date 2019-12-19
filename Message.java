public class Message{
    //fields
    private final String plaintext;
    private final String cyphertext;
    private boolean isEncrypted;
    
    //constructors
    public Message(String plaintext){
        this.plaintext = plaintext;
        this.isEncrypted = true;
    }

    public Message(String cyphertext){
        this.cyphertext = cyphertext;
        this.isEncrypted = true;
    }


}