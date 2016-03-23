package bagOfBalls.ball;

import bagOfBalls.color.Color;

/**
 * Job of class :
 * -$job
 */
public class Ball {
    private Color color;

    private Ball(Color color) {
        this.color = color;
    }

    public static Ball createYellowBall() {
        return new Ball(Color.YELLOW);
    }
    public static Ball createGreenBall() {
        return new Ball(Color.GREEN);
    }

    public static Ball createRedBall(){
        return new Ball(Color.RED);
    }

    public static Ball createBlueBall(){
        return new Ball(Color.BLUE);
    }

    public boolean isColour(Color anotherColor) {
        return anotherColor == color;
    }
}
