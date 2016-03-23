/*
    job - represent chances
 */
package probability;

import exception.InvalidInputException;

public class Chance {
    private final double value;

    private Chance(double chanceOfOccur) {
        this.value = chanceOfOccur;
    }

    public static Chance initialize(double chanceOfOccur) throws InvalidInputException {
        if (chanceOfOccur < 0 || chanceOfOccur > 1)
            throw new InvalidInputException();
        return new Chance(chanceOfOccur);
    }


    public Chance not() throws InvalidInputException {
        return initialize(1 - value);
    }

    public Chance and(Chance other) throws InvalidInputException {
        return initialize(this.value * other.value);
    }

    public Chance or(Chance other) throws InvalidInputException {
        return not().and(other.not()).not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.value, value) == 0;
    }
}
