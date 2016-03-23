package bagOfBalls.ball;

import bagOfBalls.color.Color;

import java.util.ArrayList;

public class Balls {
    private ArrayList<Ball> allBalls = new ArrayList<>();
    public int size() {
        return allBalls.size();
    }

    public boolean add(Ball ballToAdd) {
       return allBalls.add(ballToAdd);
    }

    public int getCountOfSpecifiedColorBall(Color color) {
        int count = 0;
        for (Ball eachBall : allBalls)
            if(eachBall.isColour(color))
                count++;
        return count;
    }
}
