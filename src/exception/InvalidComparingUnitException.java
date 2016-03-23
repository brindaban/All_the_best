package exception;

public class InvalidComparingUnitException extends Throwable {
    public InvalidComparingUnitException() {
        super("Can't compare between different dimension unit");
    }
}
