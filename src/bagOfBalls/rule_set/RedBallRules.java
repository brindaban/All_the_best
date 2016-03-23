package bagOfBalls.rule_set;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.color.Color;
import bagOfBalls.exception.InvalidRedBallAddingException;

/**
 * Job of class :
 * -$job
 */
public class RedBallRules implements Rule {
    @Override
    public boolean canBeAdded(Ball ballToAdd, Balls existingAllBalls) throws InvalidRedBallAddingException {
        if (ballToAdd.isColour(Color.RED)){
            int noOfExistingRedBalls = existingAllBalls.getCountOfSpecifiedColorBall(Color.RED);
            int noOfExistingGreenBalls = existingAllBalls.getCountOfSpecifiedColorBall(Color.GREEN);
            if(noOfExistingRedBalls>=(2*noOfExistingGreenBalls)-1)
                throw new InvalidRedBallAddingException();
        }
        return true;
    }
}
