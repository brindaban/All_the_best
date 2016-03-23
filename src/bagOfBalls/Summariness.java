package bagOfBalls;

/**
 * Job of class :
 * -$job
 */
public class Summariness {
    private final int noOfGreenBall;
    private final int noOfRedBall;
    private final int noOfBlueBall;
    private final int noOfYellowBall;

    public Summariness(int noOfGreenBall, int noOfRedBall, int noOfBlueBall, int noOfYellowBall) {
        this.noOfGreenBall = noOfGreenBall;
        this.noOfRedBall = noOfRedBall;
        this.noOfBlueBall = noOfBlueBall;
        this.noOfYellowBall = noOfYellowBall;
    }

    public String overview(){
        return "Bag "+(noOfBlueBall+noOfGreenBall+noOfRedBall+noOfYellowBall)+" Balls\n"+noOfGreenBall+"G  "+noOfRedBall+"R  "+noOfBlueBall+"B  "+noOfYellowBall+"Y";
    }

    public String detailedView(){
        return "Bag "+(noOfBlueBall+noOfGreenBall+noOfRedBall+noOfYellowBall)+" Balls\n" +
                "Green : "+noOfGreenBall+"\nRed : "+noOfRedBall+"\nBlue : "+noOfBlueBall+"\nYellow : "+noOfYellowBall;

    }
}
