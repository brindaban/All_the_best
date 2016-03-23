package unit;

public enum  LengthUnit implements Unit {
    FEET(300), INCHES(25), CENTIMETER(10), MILLIMETER(1);

    private final double factor;

    LengthUnit(double value) {
        this.factor = value;
    }

    @Override
    public double getBaseFactor() {
        return factor;
    }

}
