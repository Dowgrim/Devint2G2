package game;

import action.*;

import javax.imageio.ImageIO;
import javax.swing.*;
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

    public PlayerCarac carac;

    private int keyPressed;

    public Player(){
        action = new Courir();
    }

    public void paintComponent(Graphics2D g){
        int h  = getParent().getHeight();
        int w = getParent().getWidth();
        g.drawImage(action.getImage(), 0, 0, getWidth(), getHeight(), null);
    }

    public void forward(){
        action.forward();
        this.setBounds(200 + action.getShiftX(), 500 + action.getShiftY(), 50 + action.getShiftWidth(), 150 + action.getShiftHeigt());
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
}
