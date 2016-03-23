package bagOfBalls;

import exception.InvalidSizeException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BagTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Bag_will_throw_exception_if_maximum_size_is_less_than_zero() throws InvalidSizeException {
        thrown.expect(InvalidSizeException.class);
        thrown.expectMessage("Invalid size");
        Bag bagOfInvalidMaxStorage = Bag.createBag(-1);
    }

    @Test
    public void Bag_should_carry_only_three_green_balls() throws InvalidSizeException {
        Bag bagOfMax12Size = Bag.createBag(12);
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertFalse(bagOfMax12Size.putBall(new Ball(Color.GREEN)));

    }

    @Test
    public void Bag_should_not_carry_red_ballas_much_as_double_of_green_balls() throws InvalidSizeException {
        Bag bagOfMax12Size = Bag.createBag(12);
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertFalse(bagOfMax12Size.putBall(new Ball(Color.RED)));
    }

    @Test
    public void Bag_should_carry_any_no_of_blue_balls_if_there_is_space_in_the_bag() throws InvalidSizeException {
        Bag bagOfMax12Size = Bag.createBag(12);
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertFalse(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
    }

    @Test
    public void Bag_should_carry_yellow_balls_to_40_percent_of_total_balls() throws InvalidSizeException {
        Bag bagOfMax12Size = Bag.createBag(12);
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
        Assert.assertFalse(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
    }

    @Test
    public void Bag_should_give_the_overview_summary_of_bag_at_anytime() throws InvalidSizeException {
        Bag bagOfMax12Size = Bag.createBag(12);
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
        Summariness summaryOfTheCurrentBag =  bagOfMax12Size.getsSummary();
        String expected = "Bag 6 Balls\n1G  1R  2B  2Y";
        Assert.assertEquals(expected,summaryOfTheCurrentBag.overview());

    }

    @Test
    public void Bag_should_give_the_detailed_summary_of_bag_at_anytime() throws InvalidSizeException {
        Bag bagOfMax12Size = Bag.createBag(12);
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.GREEN)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.RED)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.BLUE)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
        Assert.assertTrue(bagOfMax12Size.putBall(new Ball(Color.YELLOW)));
        Summariness summaryOfTheCurrentBag =  bagOfMax12Size.getsSummary();
        String expected = "Bag 6 Balls\n" +
                "Green : 1\n" +
                "Red : 1\n" +
                "Blue : 2\n" +
                "Yellow : 2";
        Assert.assertEquals(expected,summaryOfTheCurrentBag.detailedView());

    }
}
