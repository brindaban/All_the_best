package unit;

import exception.InvalidAddingUnitException;
import exception.InvalidComparingUnitException;

import java.text.DecimalFormat;

public class Measurement {
    private final double value;
    private final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private Measurement convertToSameUnit(Measurement other) {
        double valueInSameUnit = roundTo2Decimals((other.value * other.unit.getBaseFactor()) / unit.getBaseFactor());
        return new Measurement(valueInSameUnit, unit);
    }

    public boolean isEqualTo(Measurement other) throws InvalidComparingUnitException {
        if (this.unit.getClass() != other.unit.getClass())
            throw new InvalidComparingUnitException();
        Measurement otherInSameUnit = convertToSameUnit(other);
        return this.equals(otherInSameUnit);
    }

    public Measurement add(Measurement other) throws InvalidAddingUnitException {
        if (this.unit.getClass() != other.unit.getClass())
            throw new InvalidAddingUnitException();
        Measurement otherInSameUnit = convertToSameUnit(other);
        double totalValue = roundTo2Decimals(otherInSameUnit.value + value);
        return new Measurement(totalValue, unit);
    }

    private double roundTo2Decimals(double value) {
        DecimalFormat upToTwoDecimalPosition = new DecimalFormat("###.##");
        return Double.valueOf(upToTwoDecimalPosition.format(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        return Double.compare(that.value, value) == 0 && (unit != null ? unit.equals(that.unit) : that.unit == null);

    }

}
