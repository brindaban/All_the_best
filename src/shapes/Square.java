/*
    job - calculate Area and Perimeter but all shapes.Square are a kindOf rectangle,
        so,it can be calculate by rectangle.
 */
package shapes;

import exception.InvalidScaleException;

public class Square extends Rectangle {
    private Square(double side) {
        super(side, side);
    }

    public static Square create(double side) throws InvalidScaleException {
        if (side <= 0)
            throw new InvalidScaleException();
        return new Square(side);
    }
}
