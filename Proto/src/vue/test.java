package vue;

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

    public ViewPlayer perso = new ViewPlayer();

    public int image = 0;

    public int pos = 0;

    public ArrayList<Image> IMAGES = new ArrayList<Image>();

    public ArrayList<Integer> obstacle = new ArrayList<Integer>();

    public HashMap<Integer, Integer> obstaclePos = new HashMap<Integer, Integer>();


    public test(){

        setVisible(true);

        Defilement t = new Defilement();
        t.start();
    }

    public void paint(Graphics g){
        g.drawImage(IMAGES.get(0), pos-3500, 0, 3500, 750, null);
        g.drawImage(IMAGES.get(0), pos, 0, 3500, 750, null);
        int posob = (image * 3500 + pos) / 50;
        for(int p : obstaclePos.keySet()){
            g.fillRect(obstaclePos.get(p), 550, 30, 200);
        }
        g.drawImage(perso.trolFace.get(perso.trol/17), 300, perso.posY+perso.raccour, 100, 200-perso.raccour, null);
        perso.trol = perso.trol==150?0:perso.trol+1;
    }

    public class Defilement extends Thread{

        public Defilement(){

        }

        public void run(){
            while(true){
                if(pos >= 0) {
                    pos--;
                }else{
                    pos = 3500;
                    if(image < 2){
                        image++;
                    }
                    else{
                        image = 0;
                    }
                }


                int posob = (image * 3500 + pos) / 50;
                if(obstacle.contains(posob) && !obstaclePos.containsKey(posob)){
                       obstaclePos.put(posob, 3500);
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

                if(perso.posY < 200){
                    perso.up = false;
                }
                if(perso.up){
                    perso.posY -= 3;
                }
                else {
                    if(perso.posY < 550)
                        perso.posY += 3;
                }


                if(perso.raccour > 100){
                    perso.down = false;
                }
                if(perso.down) {
                    perso.raccour += 3;
                }
                else {
                    if(perso.raccour > 0)
                        perso.raccour -= 3;
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
        f.setSize(1200, 750);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new test());
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP && ((test) f.getContentPane()).perso.posY == 550) {
                    ((test) f.getContentPane()).perso.up = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    ((test)f.getContentPane()).perso.down = true;
                }

            }
        });
        f.setVisible(true);

    }

}
