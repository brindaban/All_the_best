package bagOfBalls.bag;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.exception.BagIsFullException;
import bagOfBalls.exception.InvalidGreenBallAddException;
import bagOfBalls.exception.InvalidRedBallAddingException;
import bagOfBalls.exception.InvalidSizeException;
import bagOfBalls.rule_set.Rule;
import bagOfBalls.rule_set.Rules;

/**
 * Job of class : store balls in bag.
 * -$job
 */
public class Bag {

    private final int maxSize;
    private final Balls ballStorage;
    private final Rules rules;

    public Bag(int maxSize, Balls ballStorage, Rules rules) {

        this.maxSize = maxSize;
        this.ballStorage = ballStorage;
        this.rules = rules;
    }


    public static Bag createBag(int maxSize, Balls ballStorage, Rules rules) throws InvalidSizeException{
        if(maxSize<0)
            throw new InvalidSizeException();
        return new Bag(maxSize,ballStorage,rules);
    }

    public void addBall(Ball ballToAdd) throws BagIsFullException, InvalidGreenBallAddException, InvalidRedBallAddingException {
        if(isBagFull())
            throw new BagIsFullException();
        for (Rule rule : rules) {
            rule.canBeAdded(ballToAdd,ballStorage);
        }
        ballStorage.add(ballToAdd);
    }

    public boolean isBagFull() {
        return maxSize <= ballStorage.size();
    }
}
