package game;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;
import t2s.SIVOXDevint;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Michael on 11/03/2015.
 */
public class Obstacle extends JPanel {

    private HashMap<String, Image> images = new HashMap<String, Image>();

    private ObstacleCarac carac;

    private int key;

    private String sound;

    private String state;

    private boolean fin = false;

    public Obstacle(String image, ObstacleCarac carac, int key, String sound){
        this(image,carac,key,sound,"Normal");
    }

    public Obstacle(String image, ObstacleCarac carac, int key, String sound, String state){
        this.state=state;
        File f = new File(image);
        try {
            images.put(state, ImageIO.read(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.carac = carac;
        this.key = key;
        this.sound = sound;
        this.setSize(carac.getWidth(), carac.getHeight());
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(images.get(state), 0, 0, getWidth(), getHeight(), null);
    }

    public HashMap<String, Image> getImages() {
        return images;
    }

    public ObstacleCarac getCarac() {
        return carac;
    }

    public int getKey() {
        return key;
    }

    public String getSound() {
        return sound;
    }

    public int getCaracX(){
        return carac.getPosX();
    }

    public int getCaracY(){
        return carac.getPosY();
    }

    public int getCaracWidth(){
        return carac.getWidth();
    }

    public int getCaracHeight(){
        return carac.getHeight();
    }

    public void playSound(){
        SIVOXDevint s = new SIVOXDevint();
        s.playWav(sound, true);
    }

    public void setFin(){
        fin = true;
    }

    public boolean isFin(){
        return fin;
    }

}
