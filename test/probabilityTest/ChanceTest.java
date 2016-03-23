package probabilityTest;

import exception.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import probability.Chance;

public class ChanceTest {
    Chance chance;

    @Before
    public void setUp() throws InvalidInputException {
        chance = Chance.initialize(0.5);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void chance_give_the_probability_of_occurrence() throws InvalidInputException {
        Chance chance = Chance.initialize(0.5);
        Chance expected = Chance.initialize(0.5);
        Assert.assertEquals(expected,chance);
    }

    @Test
    public void chance_give_the_probability_of_not_occurrence() throws InvalidInputException {
        Chance chance = Chance.initialize(0.5);
        Chance expected = Chance.initialize(0.5);
        Assert.assertEquals(expected, chance.not());
    }

    @Test
    public void chance_give_the_probability_of_occurrence_of_both_event() throws InvalidInputException {
        Chance chance = Chance.initialize(0.5);
        Chance other = Chance.initialize(0.5);
        Assert.assertEquals(Chance.initialize(0.25), chance.and(other));
    }

    @Test
    public void chance_give_the_probability_of_occurrence_atLeast_one_event() throws InvalidInputException {
        Chance chance = Chance.initialize(0.5);
        Chance other = Chance.initialize(0.5);
        Assert.assertEquals(Chance.initialize(0.75), chance.or(other));
    }
    @Test
    public void chance_should_throw_exception_for_Invalid_data() throws InvalidInputException {
        thrown.expectMessage("Expected value should be greater than 0 and less than 1");
        Chance chance = Chance.initialize(9.5);
    }

}
