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

    public Player(int paramCarac){
        action = new Courir();
        carac = new PlayerCarac(paramCarac);
        setSize(50, 150);
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(action.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    public void forward(){
        action.forward();
        if(action.isEndAction()){
            action = new Courir();
        }
        this.setBounds(200 + action.getShiftX(), 310 + action.getShiftY(), 190 + action.getShiftWidth(), 430 + action.getShiftHeigt());
        repaint();
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

    public void gg(int score) {
        carac.setScore(carac.getScore() + score);
    }

    public Action getAction() {
        return action;
    }

    /**
     * toJson method for a Player
     * it contains the life of the player
     * @return JSONObject which represent this instance of player
     */
    public JSONObject toJson(){
        JSONObject playerJson = new JSONObject();
        playerJson.put("life", carac.getLife());
        
        return playerJson;
        
    }
}
