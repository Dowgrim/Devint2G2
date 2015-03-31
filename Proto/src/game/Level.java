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

    public Level(Player player, Difficulty difficulty, ArrayList<Obstacle> obstacles, BackGroundL backGround, int position){
        this.player = player;
        this.difficulty = difficulty;
        this.obstacles = obstacles;
        this.backGround = backGround;
        this.position=position;
    }
    
    public Level(ArrayList<Obstacle> obstacles, Difficulty dif){
        final Defilement t = new Defilement();
        difficulty = dif;
        setSize(1200, 750);
        //setResizable(false);
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
                        if(!t.isAlive()) {
                            t.start();
                        }
                        break;
                    }
                }
            }
        });
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        player = new Player();
        contentPane.add(player);
        player.forward();

        this.obstacles = obstacles;
        for(Obstacle o : obstacles){
            contentPane.add(o);
            o.setBounds(-400, 0, o.getCaracWidth(), o.getCaracHeight());
        }

        backGround = new BackGroundL();
        contentPane.add(backGround);
        backGround.setBounds(0, 0, getWidth(), getHeight());

        setVisible(true);
    }
    public class Defilement extends Thread {

        @Override
        public void run() {
            while (player.getScore() < 5000) {
                position++;
                player.forward();
                for(Obstacle o : obstacles) {
                    if (o.getCaracX() < position + 2000 && o.getCaracX() > position - 1000) {
                        o.setBounds((o.getCaracX() - position), o.getCaracY(), o.getCaracWidth(), o.getCaracHeight());
                        if(o.getCaracX() == position+1000){
                            o.playSound();
                        }
                    }
                    if (o.getCaracX() == (position+250) && o.getKey() != player.getKeyPressed()) {
                        if (difficulty.isPause()) {
                            while (o.getKey() != player.getKeyPressed()) {
                                int i = 0;
                                if(i==3){
                                    o.playSound();
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                i++;
                            }
                            player.gg();
                            player.setKeyPressed(-1);
                        } else {
                            player.hit();
                        }
                    }
                    else{
                        if(o.getKey() == player.getKeyPressed() && o.getCaracX() == (position+250)){
                            player.gg();
                            player.setKeyPressed(-1);
                        }
                    }
                }
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                backGround.forward(position);
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
    /*public JSONObject toJson(){
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
    }*/
}