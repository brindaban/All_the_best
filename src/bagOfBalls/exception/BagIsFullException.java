package bagOfBalls.exception;

/**
 * Job of class :
 * -$job
 */
public class BagIsFullException extends Throwable {
    public BagIsFullException() {
        super("SORRY, Bag is full !!  please create new bag");
    }
}
