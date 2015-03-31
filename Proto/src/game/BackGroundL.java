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
    private String path;
    private int position;

    public BackGroundL(){
        this.setLayout(null);

        this.path="./Proto/images/BackGround/5.jpg";

        File f = new File(path);
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        g.drawImage(background, 3500-position, 0, 3500, 750, null);
        g.drawImage(background, -position, 0, 3500, 750, null);
    }

    public void forward(int pos){
        position = (pos++) % 3500;
        repaint();
    }
    
    /**
     * toJson method for a BackGroundL object
     * It contains the path for the image and the position
     * @return a JSONObject which represent the current instance of BackGroundL
     */
    public JSONObject toJson(){
        JSONObject backgroundJson = new JSONObject();
        backgroundJson.put("path",path);
        backgroundJson.put("position",position);
        return backgroundJson;
    }
}
