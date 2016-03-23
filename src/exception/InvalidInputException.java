package exception;

public class InvalidInputException extends Throwable{
    public InvalidInputException() {
        super("Expected value should be greater than 0 and less than 1");
    }
}
