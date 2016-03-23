package bagOfBalls.rule_set;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.exception.InvalidRedBallAddingException;
import org.junit.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Job of class :
 * -$job
 */
public class RedBallRulesTest {
    private Balls allBalls;
    @Before
    public void setUp() throws Exception {
        allBalls = new Balls();
        allBalls.add(Ball.createGreenBall());
        allBalls.add(Ball.createGreenBall());
        allBalls.add(Ball.createRedBall());
        allBalls.add(Ball.createRedBall());
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void it_will_allow_to_add_red_ball_upto_one_less_of_double_of_existing_green_balls() throws InvalidRedBallAddingException {
        RedBallRules rules = new RedBallRules();
        Assert.assertTrue(rules.canBeAdded(Ball.createRedBall(),allBalls));
    }

    @Test
    public void it_will_not_allow_to_add_red_ball_moreThan_one_less_of_double_of_existing_green_balls() throws InvalidRedBallAddingException {
        allBalls.add(Ball.createRedBall());
        RedBallRules rules = new RedBallRules();
        thrown.expect(InvalidRedBallAddingException.class);
        thrown.expectMessage("SORRY, You can't add red ball, It doesn't satisfy the Red Ball Add Rule");
        Assert.assertTrue(rules.canBeAdded(Ball.createRedBall(),allBalls));

    }
}
