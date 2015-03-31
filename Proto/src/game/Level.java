package game;

import action.Glisser;
import action.Sauter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 06/03/2015.
 */
public class Level extends JFrame implements Observer {

    private Player player;

    private ArrayList<Obstacle> obstacles;

    private ArrayList<Item> items;

    private BackGroundL backGround;

    private int position;

    public Level(ArrayList<Obstacle> obstacles){
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP :{
                        player.setAction(new Sauter());
                    }
                    case KeyEvent.VK_DOWN :{
                        player.setAction(new Glisser());
                    }
                    case KeyEvent.VK_ENTER :{
                        go();
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

    private void go() {

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
