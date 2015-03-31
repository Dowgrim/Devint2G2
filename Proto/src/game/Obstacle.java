package game;

import javax.imageio.ImageIO;
import javax.swing.*;
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

    public Obstacle(String image, ObstacleCarac carac, int key, String sound){
        state = "Normal";

        File f = new File(image);
        try {
            images.put(state, ImageIO.read(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.carac = carac;
        this.key = key;
        this.sound = sound;
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

    public int getX(){
        return carac.getPosX();
    }

    public int getY(){
        return carac.getPosY();
    }

    public int getWidth(){
        return carac.getWidth();
    }

    public int getheight(){
        return carac.getHeight();
    }
}
