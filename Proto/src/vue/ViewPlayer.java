package vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 06/03/2015.
 */
public class ViewPlayer extends JPanel{

    private HashMap<String, ArrayList<Image>> images;

    private String action;

    private int image;

    public int posY = 550;

    public boolean up = false;

    public int raccour = 0;

    public boolean down = false;

    public ArrayList<Image> trolFace = new ArrayList<Image>();

    public int trol;

    public ViewPlayer(){
        File f;
        Image i = null;
        for(int j = 1; j <= 10; j++) {
            f = new File("./images/frame-" + j + ".gif");
            try {
                i = ImageIO.read(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            trolFace.add(i);
        }
    }

    public void rotate(){
        while(true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

        }
    }

    /*public void paintComponent(Graphics2D g){
        g.drawImage(trolFace.get(trol/28), 200, posY+raccour, 100, 200-raccour, null);
        g.rotate(0.2);
    }*/

    public static void main(String[] args) {
        ViewPlayer vp = new ViewPlayer();
        vp.repaint();
        JFrame f = new JFrame();
        f.setContentPane(vp);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
