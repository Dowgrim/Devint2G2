package game;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 25/03/2015.
 */
public class BackGroundL extends JPanel{

    private Image background;

    public BackGroundL(String backGround){

        File f = new File(backGround);
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BackGroundL(JSONObject backGround){
        File f = new File(backGround.getString("image"));
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(), getHeight());
        g.drawImage(background, 0, 0, 3500, 750, null);
        g.drawImage(background, 3500, 0, 3500, 750, null);
    }

    public void forward(int pos){
        setBounds(-(pos % 3500), 0, 5000, 750);
    }
    
    /**
     * toJson method for a BackGroundL object
     * It contains the path for the image and the position
     * @return a JSONObject which represent the current instance of BackGroundL
     */
    /*public JSONObject toJson(){
        JSONObject backgroundJson = new JSONObject();
        backgroundJson.put("path",path);
        backgroundJson.put("position",position);
        return backgroundJson;
    }*/
}
