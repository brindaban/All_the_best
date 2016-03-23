package bagOfBalls.exception;

/**
 * Job of class :
 * -$job
 */
public class InvalidGreenBallAddException extends Throwable {
    public InvalidGreenBallAddException() {
        super("SORRY, You can't add green ball, It doesn't satisfy the Green Ball Add Rule");
    }
}
