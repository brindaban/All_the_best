package bagOfBalls.rule_set;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.color.Color;
import bagOfBalls.exception.InvalidGreenBallAddException;

/**
 * Job of class :
 * -$job
 */
public class GreenBallRules implements Rule {
    private final int maxball;

    public GreenBallRules(int maxBall) {
        this.maxball = maxBall;
    }

    @Override
    public boolean canBeAdded(Ball ballToAdd, Balls existingAllBalls) throws InvalidGreenBallAddException {
        if(ballToAdd.isColour(Color.GREEN)){
            int noOfExistingGreenBalls = existingAllBalls.getCountOfSpecifiedColorBall(Color.GREEN);
            if (noOfExistingGreenBalls>=maxball)
                throw new InvalidGreenBallAddException();
        }
        return true;
    }
}
