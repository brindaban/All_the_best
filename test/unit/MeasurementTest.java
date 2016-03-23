package unit;

import exception.InvalidAddingUnitException;
import exception.InvalidComparingUnitException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MeasurementTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void measurement_of_inches_and_measurement_of_feet_gives_true_when_they_are_equal() throws InvalidComparingUnitException {
        Measurement measurementOfFeet = new Measurement(1, LengthUnit.FEET);
        Measurement measurementOfInches = new Measurement(12, LengthUnit.INCHES);
        Assert.assertTrue(measurementOfFeet.isEqualTo(measurementOfInches));

    }
    @Test
    public void measurement_of_inches_and_measurement_of_centimeter_gives_true_when_they_are_equal() throws InvalidComparingUnitException {
        Measurement measurementOfCentimeter = new Measurement(2.5, LengthUnit.CENTIMETER);
        Measurement measurementOfInches = new Measurement(1, LengthUnit.INCHES);
        Assert.assertTrue(measurementOfInches.isEqualTo(measurementOfCentimeter));
    }

    @Test
    public void measurement_of_centimeter_and_measurement_of_millimeter_gives_true_when_they_are_equal() throws InvalidComparingUnitException {
        Measurement measurementOfCentimeter = new Measurement(2, LengthUnit.CENTIMETER);
        Measurement measurementOfMillimeter = new Measurement(20, LengthUnit.MILLIMETER);
        Assert.assertTrue(measurementOfMillimeter.isEqualTo(measurementOfCentimeter));
    }

    @Test
    public void measurement_of_gallon_and_measurement_of_litre_gives_true_when_they_are_equal() throws InvalidComparingUnitException {
        Measurement measurementOfGallon = new Measurement(1, VolumeUnit.GALLON);
        Measurement measurementOfLitre = new Measurement(3.78, VolumeUnit.LITRE);
        Assert.assertTrue(measurementOfLitre.isEqualTo(measurementOfGallon));
    }

    @Test
    public void compare_of_two_different_dimension_unit_throws_exception() throws InvalidComparingUnitException {
        thrown.expectMessage("Can't compare between different dimension unit");
        Measurement measurementOfLitre = new Measurement(3.78, VolumeUnit.LITRE);
        Measurement measurementOfMillimeter = new Measurement(20, LengthUnit.MILLIMETER);
        measurementOfLitre.isEqualTo(measurementOfMillimeter);

    }

    @Test
    public void addition_of_1_gallon_and_1_litre_gives_4_point_78_litre() throws InvalidAddingUnitException {
        Measurement measurementOfGallon = new Measurement(1, VolumeUnit.GALLON);
        Measurement measurementOfLitre = new Measurement(1, VolumeUnit.LITRE);
        Assert.assertEquals(new Measurement(4.78,VolumeUnit.LITRE),measurementOfLitre.add(measurementOfGallon));
    }

    @Test
    public void addition_of_2_feet_and_36_inches_gives_5_feet() throws InvalidAddingUnitException {
        Measurement measurementOfFeet = new Measurement(2, LengthUnit.FEET);
        Measurement measurementOfInches = new Measurement(36, LengthUnit.INCHES);
        Assert.assertEquals(new Measurement(5,LengthUnit.FEET),measurementOfFeet.add(measurementOfInches));
        Assert.assertEquals(new Measurement(60,LengthUnit.INCHES),measurementOfInches.add(measurementOfFeet));
    }

    @Test
    public void addition_of_two_different_dimension_unit_throws_exception() throws  InvalidAddingUnitException {
        thrown.expectMessage("Can't add between two different dimension unit");
        Measurement measurementOfLitre = new Measurement(3.78, VolumeUnit.LITRE);
        Measurement measurementOfMillimeter = new Measurement(20, LengthUnit.MILLIMETER);
        measurementOfLitre.add(measurementOfMillimeter);

    }
}
