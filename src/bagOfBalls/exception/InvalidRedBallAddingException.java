package bagOfBalls.exception;

/**
 * Job of class :
 * -$job
 */
public class InvalidRedBallAddingException extends Throwable {
    public InvalidRedBallAddingException() {
        super("SORRY, You can't add red ball, It doesn't satisfy the Red Ball Add Rule");
    }
}
