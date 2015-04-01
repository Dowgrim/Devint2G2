package game;

import action.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import action.Action;

/**
 * Created by Michael on 06/03/2015.
 */
public class Player extends JPanel{

    private Action action;

    public PlayerCarac carac = new PlayerCarac(0);

    private int keyPressed = -1;

    public Player(){
        action = new Courir();
    }

    public Player(Action act, PlayerCarac playCarac, int keyPressed){
        this.action = act;
        this.carac = playCarac;
        this.keyPressed = keyPressed;
    }
    
    public void paintComponent(Graphics2D g){
        g.drawImage(action.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    public void forward(){
        action.forward();
        if(action.isEndAction()){
            action = new Courir();
        }
        this.setBounds(200 + action.getShiftX(), 400 + action.getShiftY(), 50 + action.getShiftWidth(), 150 + action.getShiftHeigt());
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getScore(){
        return carac.getScore();
    }

    public void setKeyPressed(int keyPressed) {
        this.keyPressed = keyPressed;
    }

    public int getKeyPressed() {
        return keyPressed;
    }

    public void hit(){
        carac.setLife(carac.getLife() - 1);
    }

    public void gg() {
        carac.setScore(carac.getScore() + 500);
    }
    
    /**
     * toJson method for a Player
     * it contains the associated PlayerCarac in json,
     * the action and the keypressed in json;
     * @return JSONObject which represent this instance of player
     */
    public JSONObject toJson(){
        JSONObject playerJson = new JSONObject();
        playerJson.put("carac", carac.toJson());
        playerJson.put("action",action.toJson());
        playerJson.put("keypressed",keyPressed);
        
        return playerJson;
        
    }
}
