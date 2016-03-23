package exception;

public class InvalidAddingUnitException extends Throwable{
    public InvalidAddingUnitException() {
        super("Can't add between two different dimension unit");
    }
}
