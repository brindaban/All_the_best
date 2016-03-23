package bagOfBalls.rule_set;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;

/**
 * Job of class :
 * -$job
 */
public class YellowBalRules implements Rule {
    private final double ratioToAccept;

    public YellowBalRules(double ratioToAccept) {
        this.ratioToAccept = ratioToAccept;
    }

    @Override
    public boolean canBeAdded(Ball ballToAdd, Balls existingAllBalls) {
        return true;
    }
}
