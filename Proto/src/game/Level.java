package game;

import action.Glisser;
import action.Sauter;

import javax.swing.*;
import java.util.Timer;

import org.json.JSONArray;
import org.json.JSONObject;
import t2s.SIVOXDevint;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by Michael on 06/03/2015.
 */
public class Level extends JFrame {

    private Player player;
    private Difficulty difficulty;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Item> items;
    private BackGroundL backGround;
    private int position = 0;
    private String musique;
    private JLabel score;
    private SIVOXDevint s = new SIVOXDevint();

    public Level(Player player, Difficulty difficulty, ArrayList<Obstacle> obstacles, BackGroundL backGround, int position) {
        this.player = player;
        this.difficulty = difficulty;
        this.obstacles = obstacles;
        this.backGround = backGround;
        this.position = position;
    }

    public Level(ArrayList<Obstacle> obstacles, Difficulty dif) {
        final Defilement t = new Defilement();
        musique = "./sons/musique.wav";
        difficulty = dif;
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        if (!(player.getAction() instanceof Sauter)) {
                            player.setAction(new Sauter());
                            player.setKeyPressed(e.getKeyCode());
                        }
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        player.setAction(new Glisser());
                        player.setKeyPressed(e.getKeyCode());
                        break;
                    }
                    case KeyEvent.VK_ENTER: {
                        if (!t.isAlive()) {
                            t.start();
                            s.playWav(musique);
                        }
                        break;
                    }
                    case KeyEvent.VK_W: {
                        backGround.setImage("./images/BackGround/Plaine.png");
                        break;
                    }
                    case KeyEvent.VK_X: {
                        backGround.setImage("./images/BackGround/Montagne.png");
                        break;
                    }
                    case KeyEvent.VK_C: {
                        backGround.setImage("./images/BackGround/Savane.png");
                        break;
                    }
                }
            }
        });


        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        player = new Player(0);
        contentPane.add(player);
        player.forward();

        score = new JLabel(player.getScore() + "");
        score.setFont(new Font("Arial", Font.PLAIN, 40));
        score.setBounds(getWidth() - 120, 0, 200, 30);
        contentPane.add(score);

        this.obstacles = obstacles;
        for (Obstacle o : obstacles) {
            contentPane.add(o);
            o.setBounds(-400, 0, o.getCaracWidth(), o.getCaracHeight());
        }

        backGround = new BackGroundL("./images/BackGround/Plaine.png");
        contentPane.add(backGround);
        backGround.setBounds(0, 0, getWidth(), getHeight());


        setVisible(true);
    }

    public class Defilement extends Thread {

        Timer time = new Timer(this.getName());

        public Defilement(){
            super("unNom");
            time = new Timer(this.getName());
        }

        @Override
        public void run() {
            time.schedule(new TaskSechedul(), 0, 1);
        }
    }

    public class TaskSechedul extends TimerTask {

        @Override
        public void run() {

            position++;
            player.forward();
            for (Obstacle o : obstacles) {
                if (o.getCaracX() < position + 2000 && o.getCaracX() > position - 1000) {
                    o.setBounds((o.getCaracX() - position), o.getCaracY(), o.getCaracWidth(), o.getCaracHeight());
                    if (o.getCaracX() == position + 500) {
                        o.playSound();
                    }
                }
                if((o.getCaracX() == (position + 150))) {
                    if (o.isFin()) {
                        new Win();
                        this.cancel();
                    }else {
                        if ((player.getAction().onBonus())) {
                            player.gg(1000);

                        }
                    }
                }
                if (o.getCaracX() == (position + 300) && o.getKey() != player.getKeyPressed()) {
                    if (difficulty.isPause()) {
                        int i = 0;
                        while (o.getKey() != player.getKeyPressed()) {
                            if (i == 100) {
                                o.playSound();
                                i = 0;
                            }
                            try {
                                Thread.sleep(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            i++;
                        }
                        player.gg(500);
                        score.setText(player.getScore() + "");
                        player.setKeyPressed(-1);
                    } else {
                        player.hit();
                    }
                } else {
                    if (o.getKey() == player.getKeyPressed() && o.getCaracX() == (position + 300)) {
                        player.gg(500);
                        score.setText(player.getScore() + "");
                        player.setKeyPressed(-1);
                    }
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            backGround.forward(position);
        }
    }

}