package bagOfBalls.ball;

import bagOfBalls.color.Color;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Job of class :
 * -$job
 */
public class BallsTest {
    Balls allBalls;
    @Before
    public void setUp() throws Exception {
        allBalls = new Balls();
        allBalls.add(Ball.createGreenBall());
        allBalls.add(Ball.createBlueBall());

    }

    @Test
    public void size_will_give_the_no_of_total_balls() {
        Assert.assertEquals(2,allBalls.size());
    }

    @Test
    public void add_balls_into_the_list() {
        allBalls.add(Ball.createRedBall());
        Assert.assertEquals(3,allBalls.size());
    }

    @Test
    public void countOfSpecifiedColorBall_return_current_ball_count_of_given_color() {
        Assert.assertEquals(1,allBalls.getCountOfSpecifiedColorBall(Color.GREEN));
    }
}
