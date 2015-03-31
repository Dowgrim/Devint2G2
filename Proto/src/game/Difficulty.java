package game;

/**
 * Created by Michael on 31/03/2015.
 */
public enum Difficulty {
    VeryEasy(true, 0, 1),
    Easy(false, 5, 1);

    private boolean pause;

    private int time;

    private double speed;

    Difficulty(boolean pause, int time, double speed){
        this.time = time;
        this.pause = pause;
        this.speed = speed;
    }

    public boolean isPause() {
        return pause;
    }

    public int getTime() {
        return time;
    }

    public double getSpeed() {
        return speed;
    }
}
