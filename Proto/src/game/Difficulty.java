package game;

import org.json.JSONObject;

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
    
    /**
     * toJson method for the difficulty
     * @return a JSONObject which represent the current instance of Difficulty
     */
    public JSONObject toJson(){
        JSONObject difficultyJson = new JSONObject();
        difficultyJson.put("pause", pause);
        difficultyJson.put("time", time);
        difficultyJson.put("speed", speed);
        return difficultyJson;
    }
}
