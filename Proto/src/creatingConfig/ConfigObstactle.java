package creatingConfig;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import action.Action;
import game.BackGroundL;
import game.Difficulty;
import game.Item;
import game.Level;
import game.Obstacle;
import game.ObstacleCarac;
import game.Player;
import game.PlayerCarac;

/**
 * Created by Michael on 31/03/2015.
 */
public abstract class ConfigObstactle {


    public static Obstacle configObstacle(JSONObject obstacle){
        JSONObject carac = obstacle.getJSONObject("carac");
        
        if(carac==null){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " No 'carac' in it.");
        }
        
        ObstacleCarac caracObstacle;
        try{
            caracObstacle = new ObstacleCarac(carac.getInt("posX"),carac.getInt("posY"),carac.getInt("width"),carac.getInt("height"));
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " The argument hasn't 'posX', 'posY', 'width', 'height' or they aren't int");
        }
        
        String img,snd,state;
        int key;
        
        try{
            img = obstacle.getString("image");
            snd = obstacle.getString("sound");
            state = obstacle.getString("state");
            key = obstacle.getInt("key");
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " The argument hasn't 'image', 'sound', 'state', 'key' or they aren't String for the first three"
                    + "and int for the last one");
        }
        
        Obstacle obst = new Obstacle(img,caracObstacle,key,snd,state);
        return obst;
    }

    public static Difficulty configDifficulty(JSONObject diff){
        boolean pause;
        int time;
        double speed;
        try{
            pause=diff.getBoolean("pause");
            time=diff.getInt("time");
            speed=diff.getDouble("speed");
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject diff in ConfigObstactle.configDifficutly."
                    +" The argument hasn't 'pause' or isn't a boolean, 'time' or isn't an int, 'speed' or isn't a Double");
        }
        return Difficulty.getDifficulty(pause,time,speed);
    }
    
    public static Action configAction(JSONObject action){
        int image,shiftX,shiftY,shiftWidth,shiftHeight;
        try{
            image = action.getInt("image");
            shiftX = action.getInt("shiftX");
            shiftY = action.getInt("shiftY");
            shiftWidth = action.getInt("shiftWidth");
            shiftHeight = action.getInt("shiftHeight");
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject diff in ConfigObstactle.configAction."
                    +" The argument hasn't 'img', 'shiftX', 'shiftY', 'shiftWidth', 'shiftHeight' or aren't int");
        }
        Action act = new Action();
        act.setImage(image);
        act.setShiftX(shiftX);
        act.setShiftY(shiftY);
        act.setShiftHeigt(shiftHeight);
        act.setShiftWidth(shiftWidth);
        return act;
    }
    
    public static Player playerConfig(JSONObject player){
        JSONObject caracPlayer = player.getJSONObject("carac");
        PlayerCarac carac;
        try{
            carac = new PlayerCarac(caracPlayer.getInt("life"),caracPlayer.getInt("MAXLIFE"),caracPlayer.getInt("score"));
        }catch (Exception e){
            throw new IllegalArgumentException("Error parsing the carac JSONObject in player. Missing arguments in it.");
        }
        
        Action act = ConfigObstactle.configAction(player.getJSONObject("action"));
        
        int keyPressed;
        try{
            keyPressed = player.getInt("keypressed");
        }catch (Exception e){
            throw new IllegalArgumentException("Error parsing the player JSONObject. Missing the int argument for 'keypressed'.");
        }
        
        return new Player(act, carac,keyPressed);
    }
    
    public static BackGroundL backgroundConfig(JSONObject back){
        String path="";
        int position=0;
        try{
            path=back.getString("path");
            position=back.getInt("position");
        }catch (Exception e){
            
        }
        return new BackGroundL(path,position);
    }
    
    public static Level levelConfig(JSONObject level){
        Player player = ConfigObstactle.playerConfig(level.getJSONObject("player"));
        Difficulty diff = ConfigObstactle.configDifficulty(level.getJSONObject("difficulty"));
        BackGroundL backGround = ConfigObstactle.backgroundConfig(level.getJSONObject("background"));
        int position = level.getInt("position");
        JSONArray obstacles = level.getJSONArray("obstacle");
        ArrayList<Obstacle> obst = new ArrayList<Obstacle>();
        for(int i=0; i<obstacles.length();i++){
            obst.add(ConfigObstactle.configObstacle(obstacles.getJSONObject(i)));
        }
        return new Level(player, diff, obst, backGround, position);
    }
}
