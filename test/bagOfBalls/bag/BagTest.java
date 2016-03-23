package bagOfBalls.bag;

import bagOfBalls.ball.Ball;
import bagOfBalls.ball.Balls;
import bagOfBalls.exception.BagIsFullException;
import bagOfBalls.exception.InvalidGreenBallAddException;
import bagOfBalls.exception.InvalidRedBallAddingException;
import bagOfBalls.exception.InvalidSizeException;
import bagOfBalls.rule_set.GreenBallRules;
import bagOfBalls.rule_set.RedBallRules;
import bagOfBalls.rule_set.Rules;
import bagOfBalls.rule_set.YellowBalRules;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BagTest {
    private Bag bagOfSizeTwelve;

    @Before
    public void setUp() throws Exception, InvalidSizeException {
        Balls ballStorage = new Balls();
        Rules rules = new Rules();
        rules.add(new GreenBallRules(3));
        rules.add(new RedBallRules());
        rules.add(new YellowBalRules(0.4));
        bagOfSizeTwelve = Bag.createBag(12,ballStorage,rules);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void Bag_will_throw_exception_if_maximum_size_is_less_than_zero() throws InvalidSizeException {
        thrown.expect(InvalidSizeException.class);
        thrown.expectMessage("Invalid size");
        Balls ballStorage = new Balls();
        Rules rules = new Rules();
        Bag bagOfInvalidMaxStorage = Bag.createBag(-1,ballStorage,rules);
    }

    @Test
    public void Bag_will_throw_bag_full_exception_if_bag_is_full_and_then_anyone_want_to_add_a_ball() throws InvalidSizeException, BagIsFullException, InvalidGreenBallAddException, InvalidRedBallAddingException {
        Balls ballStorage = new Balls();
        Rules rules = new Rules();
        Bag bagOgSizeZero = Bag.createBag(0,ballStorage,rules);
        thrown.expect(BagIsFullException.class);
        thrown.expectMessage("SORRY, Bag is full !!  please create new bag");
        bagOgSizeZero.addBall(Ball.createGreenBall());
    }

    @Test
    public void Bag_will_initially_allow_to_Insert_uptoThree_green_balls() throws BagIsFullException, InvalidGreenBallAddException, InvalidRedBallAddingException {
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
    }

    @Test
    public void Bag_will_throw_InvalidGreenBallAddException_if_anyOne_try_to_add_more_than_three_green_balls() throws InvalidGreenBallAddException, BagIsFullException, InvalidRedBallAddingException {
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
        thrown.expect(InvalidGreenBallAddException.class);
        thrown.expectMessage("SORRY, You can't add green ball, It doesn't satisfy the Green Ball Add Rule");
        bagOfSizeTwelve.addBall(Ball.createGreenBall());
    }
}
