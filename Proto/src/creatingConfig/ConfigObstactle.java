package creatingConfig;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import game.BackGroundL;
import game.Difficulty;
import game.Level;
import game.Obstacle;
import game.ObstacleCarac;
import game.Player;

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
        
        String img,snd;
        int key;
        
        try{
            img = obstacle.getString("image");
            snd = obstacle.getString("sound");
            key = obstacle.getInt("key");
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " The argument hasn't 'image', 'sound', 'state', 'key' or they aren't String for the first three"
                    + "and int for the last one");
        }
        
        Obstacle obst = new Obstacle(img,caracObstacle,key,snd);
        return obst;
    }
    
    public static List<Obstacle> levelConfig(JSONObject level){
        JSONArray obstacles = level.getJSONArray("obstacles");
        List<Obstacle> obst = new ArrayList<Obstacle>();
        for(int i=0; i<obstacles.length();i++){
            obst.add(ConfigObstactle.configObstacle(obstacles.getJSONObject(i)));
        }
        return obst;
    }
}
