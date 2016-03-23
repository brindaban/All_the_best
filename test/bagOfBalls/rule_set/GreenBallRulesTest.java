package bagOfBalls.rule_set;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.exception.InvalidGreenBallAddException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Job of class :
 * -$job
 */
public class GreenBallRulesTest {
    Balls allBalls;
    @Before
    public void setUp() throws Exception {
        allBalls = new Balls();
        allBalls.add(Ball.createGreenBall());
        allBalls.add(Ball.createGreenBall());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void rule_will_return_true_upto_three_green_ball_in_ballstorage() throws InvalidGreenBallAddException {
        GreenBallRules rule = new GreenBallRules(3);
        Assert.assertTrue(rule.canBeAdded(Ball.createGreenBall(),allBalls));
    }

    @Test
    public void It_will_throw_Invalid_Green_Ball_Add_Exception_if_there_is_already_three_green_ball_in_ballstorage() throws InvalidGreenBallAddException {
        GreenBallRules rule = new GreenBallRules(3);
        allBalls.add(Ball.createGreenBall());
        thrown.expect(InvalidGreenBallAddException.class);
        thrown.expectMessage("SORRY, You can't add green ball, It doesn't satisfy the Green Ball Add Rule");
        Assert.assertTrue(rule.canBeAdded(Ball.createGreenBall(),allBalls));

    }
}
