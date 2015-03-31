package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 03/03/2015.
 */
public class test extends JPanel {

    public int posY = 400;

    public boolean up = false;

    public int raccour = 0;

    public boolean down = false;

    public int image = 0;

    public int pos = 0;

    public ArrayList<Image> IMAGES = new ArrayList<Image>();

    public ArrayList<Integer> obstacle = new ArrayList<Integer>();

    public HashMap<Integer, Integer> obstaclePos = new HashMap<Integer, Integer>();

    public ArrayList<Image> trolFace = new ArrayList<Image>();

    public int trol;

    public test(){

        File f = new File("./images/1.jpg");
        Image i = null;
        try {
            i = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IMAGES.add(i);

        f = new File("./images/2.jpg");
        try {
            i = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IMAGES.add(i);

        f = new File("./images/3.jpg");
        try {
            i = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IMAGES.add(i);

        for(int j = 1; j <= 10; j++) {
            f = new File("./images/frame-" + j + ".gif");
            try {
                i = ImageIO.read(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            trolFace.add(i);
        }

        obstacle.add(10);
        obstacle.add(40);
        obstacle.add(50);
        obstacle.add(80);


        setVisible(true);

        Defilement t = new Defilement();
        t.start();
    }

    public void paint(Graphics g){
        g.drawImage(IMAGES.get(image==0?2:image-1), pos-1280, 0, 1280, 800, null);
        g.drawImage(IMAGES.get(image), pos, 0, 1280, 800, null);
        int posob = (image * 1280 + pos) / 50;
        for(int p : obstaclePos.keySet()){
            g.fillRect(obstaclePos.get(p), 600, 30, 200);
        }
        g.drawImage(trolFace.get(trol/15), 200, posY+raccour, 200, 400-raccour, null);
        trol = trol==145?0:trol+1;
    }

    public class Defilement extends Thread{

        public Defilement(){

        }

        public void run(){
            while(true){
                if(pos >= 0) {
                    pos--;
                }else{
                    pos = 1280;
                    if(image < 2){
                        image++;
                    }
                    else{
                        image = 0;
                    }
                }


                int posob = (image * 1280 + pos) / 50;
                if(obstacle.contains(posob) && !obstaclePos.containsKey(posob)){
                       obstaclePos.put(posob, 1280);
                }

                int sup = 0;
                for(int p : obstaclePos.keySet()){
                    int ob = obstaclePos.get(p);
                    obstaclePos.put(p, ob-1);
                    if(ob == -200){
                        sup = p;
                    }
                }

                if(sup != 0){
                    obstaclePos.remove(sup);
                }

                if(posY < 0){
                    up = false;
                }
                if(up){
                    if(posY<100){
                        posY -= 1;
                    }
                    else {
                        if (posY < 200) {
                            posY -= 2;
                        } else {
                            posY -= 3;
                        }
                    }
                }
                else {
                    if(posY < 400)
                        posY += 3;
                }


                if(raccour > 200){
                    down = false;
                }
                if(down) {
                    raccour += 3;
                }
                else {
                    if(raccour > 0)
                        raccour -= 3;
                }


                repaint();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final JFrame f = new JFrame("Projet Devint");
        f.setSize(1280, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new test());
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP && ((test) f.getContentPane()).posY >= 400) {
                    ((test) f.getContentPane()).up = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    ((test)f.getContentPane()).down = true;
                }

            }
        });
        f.setVisible(true);

    }

}