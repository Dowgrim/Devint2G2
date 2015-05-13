package creatingConfig;

import game.Obstacle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Michael on 31/03/2015.
 */
public class FileInteraction {
    private static String pathFile = "../ressources/level.txt";
    
    public static void save(List<Obstacle> obs){
        JSONObject level = new JSONObject();
        JSONArray array = new JSONArray();
        for(Obstacle o : obs){
            array.put(o.toJson());
        }
        level.put("obstacles", array);
        FileInteraction.saveLevel(level);
    }
    /**
     * Save a level into a file
     * @param level, a JSONObject which represent a Level
     */
    public static void saveLevel(JSONObject level){
        try {
            FileWriter file = new FileWriter(pathFile);
            file.write(level.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Load the file and return the corresponding JSONObject
     * @return the list of obstacle as a JSONObject
     */
    public static JSONObject loadLevel(){
        String json="";
        try{
            InputStream flux=new FileInputStream(pathFile); 
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            while ((ligne=buff.readLine())!=null){
                json+=ligne;
            }
            buff.close(); 
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JSONObject jsonLevel = new JSONObject(json);
        return jsonLevel;
    }
}
