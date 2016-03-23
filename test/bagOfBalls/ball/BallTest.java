package bagOfBalls.ball;

import bagOfBalls.color.Color;
import org.junit.Assert;
import org.junit.Test;

/**
 * Job of class :
 * -$job
 */
public class BallTest {
    @Test
    public void it_the_ball_is_of_given_color_it_return_true() {
        Ball yellowBall = Ball.createYellowBall();
        Assert.assertTrue(yellowBall.isColour(Color.YELLOW));
    }
}
