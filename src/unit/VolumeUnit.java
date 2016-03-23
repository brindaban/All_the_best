package unit;

public enum VolumeUnit implements Unit {
    GALLON(3.78), LITRE(1);

    private double factor;

    VolumeUnit(double value) {
        this.factor = value;
    }

    @Override
    public double getBaseFactor() {
        return factor;
    }

}
