package bagOfBalls.rule_set;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.exception.InvalidGreenBallAddException;
import bagOfBalls.exception.InvalidRedBallAddingException;

public interface Rule {
    boolean canBeAdded(Ball ballToAdd, Balls existingAllBalls) throws InvalidGreenBallAddException, InvalidRedBallAddingException;
}
