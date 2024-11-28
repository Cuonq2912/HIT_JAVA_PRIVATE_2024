package exception;

public class DuplicateException extends Exception{
    private String message;

    public DuplicateException(String message, String message1) {
        super(message);
        this.message = message1;
    }

}
