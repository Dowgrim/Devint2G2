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
        g.drawImage(action.getImage(), 0, 0, 50, 150, null);
    }

    public void Avancer(){
        action.forward();
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
