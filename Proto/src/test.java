import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 03/03/2015.
 */
public class test extends JFrame {

    public int image = 0;

    public int pos = 0;

    public ArrayList<Image> IMAGES = new ArrayList<Image>();

    public ArrayList<Integer> obstacle = new ArrayList<Integer>();

    public HashMap<Integer, Integer> obstaclePos = new HashMap<Integer, Integer>();

    public test(){
        setTitle("Test");
        setSize(1280, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
            g.fillRect(obstaclePos.get(p), 600, 200, 200);
        }
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
                for(int p : obstaclePos.keySet()){
                    int ob = obstaclePos.get(p);
                    obstaclePos.put(p, ob-1);
                    if(ob == -200){
                        obstaclePos.remove(p);
                    }
                }

                repaint();
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new test();
    }

}
