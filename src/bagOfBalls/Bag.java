package bagOfBalls;

import exception.InvalidSizeException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Job of class : store balls in bag.
 * -$job
 */
public class Bag {
    private int sizeOfBag;
    private HashMap<Color,ArrayList<Ball>> ballsStorage=new HashMap<>();
    private final int maxGreenBall = 3;
    private int currentBallCount=0;

    private Bag(int sizeOfBag) {
        this.sizeOfBag = sizeOfBag;
    }

    public static Bag createBag(int maxSize) throws InvalidSizeException{
        if(maxSize<0)
            throw new InvalidSizeException();
        return new Bag(maxSize);
    }

    public boolean putBall(Ball ball){
        if (currentBallCount==sizeOfBag) return false;
        if(ball.isColour(Color.GREEN)&&getNoOfSpecifiedColorBalls(Color.GREEN)<maxGreenBall)
            return updateSpecifiedColorBallStorage(ball,Color.GREEN);
        if(ball.isColour(Color.RED)&&getNoOfSpecifiedColorBalls(Color.RED)<2*getNoOfSpecifiedColorBalls(Color.GREEN)-1)
            return updateSpecifiedColorBallStorage(ball,Color.RED);
        if(ball.isColour(Color.BLUE))
            return updateSpecifiedColorBallStorage(ball,Color.BLUE);
        if (ball.isColour(Color.YELLOW)&&Math.round((getNoOfSpecifiedColorBalls(Color.YELLOW)+1)*100/currentBallCount)<=40.0)
            return updateSpecifiedColorBallStorage(ball,Color.YELLOW);
        return false;
    }
    private int getNoOfSpecifiedColorBalls(Color color){
        if(ballsStorage.containsKey(color))
            return ballsStorage.get(color).size();
        return 0;
    }

    private boolean updateSpecifiedColorBallStorage(Ball ball,Color color){
        if(getNoOfSpecifiedColorBalls(color)!=0){
            ArrayList<Ball> existingBall = ballsStorage.get(color);
            existingBall.add(ball);
            ballsStorage.put(color,existingBall);
        }
        else{
            ArrayList<Ball> initial = new ArrayList<>();
            initial.add(ball);
            ballsStorage.put(color,initial);
        }
        currentBallCount++;
        return true;
    }

    public Summariness getsSummary(){
        int noOfGreenBalls = getNoOfSpecifiedColorBalls(Color.GREEN);
        int noOfRedBalls = getNoOfSpecifiedColorBalls(Color.RED);
        int noOfBlueBalls = getNoOfSpecifiedColorBalls(Color.BLUE);
        int noOfYellowBalls = getNoOfSpecifiedColorBalls(Color.YELLOW);
        return new Summariness(noOfGreenBalls,noOfRedBalls,noOfBlueBalls,noOfYellowBalls);
    }
}
