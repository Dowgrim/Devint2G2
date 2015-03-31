package game;

import action.Glisser;
import action.Sauter;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 06/03/2015.
 */
public class Level extends JFrame{

    private Player player;

    private Difficulty difficulty;

    private ArrayList<Obstacle> obstacles;

    private ArrayList<Item> items;

    private BackGroundL backGround;

    private int position = 0;

    public Level(ArrayList<Obstacle> obstacles, Difficulty dif){
        final Defilement t = new Defilement();
        difficulty = dif;
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP :{
                        player.setAction(new Sauter());
                        player.setKeyPressed(e.getKeyCode());
                        break;
                    }
                    case KeyEvent.VK_DOWN :{
                        player.setAction(new Glisser());
                        player.setKeyPressed(e.getKeyCode());
                        break;
                    }
                    case KeyEvent.VK_ENTER :{
                        t.start();
                        break;
                    }
                }
            }
        });
        backGround = new BackGroundL();
        setContentPane(backGround);

        player = new Player();
        backGround.add(player, 200, 400);

        this.obstacles = obstacles;
        for(Obstacle o : obstacles){
            backGround.add(o);
        }

        setVisible(true);
    }

    public class Defilement extends Thread {

        @Override
        public void run() {
            while (player.getScore() < 5000) {
                position++;
                player.forward();
                backGround.forward(position);
                for(Obstacle o : obstacles) {
                    if(o.getX() < position + 2000 && o.getX() > position) {
                        o.setBounds(o.getX() - position, o.getY(), o.getWidth(), o.getheight());
                    }
                    if(o.getX() == position && o.getKey() != player.getKeyPressed()){
                        if(difficulty.isPause()){
                            while(o.getKey() != player.getKeyPressed()){
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else{
                            player.hit();}
                        }
                    else{
                        if(o.getKey() == player.getKeyPressed()){
                            player.gg();
                        }
                    }
                }
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * ToJson method for a level
     * It will return a JSon containing
     * all the obstacle and their coordinates, the difficulty,
     * the background, the position in the level, and the player
     * @return a JSONOBject which represent this instance of level
     */
    public JSONObject toJson(){
        JSONObject levelJson = new JSONObject();
        levelJson.put("difficulty", difficulty.toJson());
        levelJson.put("background",backGround.toJson());
        levelJson.put("position", position);
        JSONArray obstacle = new JSONArray();
        for(Obstacle o : obstacles){
            obstacle.put(o.toJson());
        }
        levelJson.put("obstacles",obstacle);
        levelJson.put("player",player.toJson());
        return levelJson;
    }
}