package bagOfBalls;

/**
 * Job of class :
 * -$job
 */
public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public boolean isColour(Color anotherColor){
        return anotherColor == color;
    }
}
