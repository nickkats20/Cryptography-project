public class Message {
    // fields
    private final String message;
    private boolean isEncrypted;

    // constructors
    public Message(String message, boolean isEncrypted) {
        this.message = message;
        this.isEncrypted = isEncrypted;
    }

    // methods
    public boolean getEncryptionStatus() {
        return isEncrypted;
    }

    public String getMessage() {
        return message;
    }
}