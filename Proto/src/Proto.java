import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Michael on 03/03/2015.
 */
public class Proto extends JFrame {

    private int position = 0;
    

    private ArrayList<Integer> obstacle;

    private JPanel contentPane;

    public Proto(){
        super("Proto Devint");
        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public class Defilement extends Thread{

        int image = 0;

        ArrayList<Image> IMAGES;

        public Defilement(){
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
        }

        @Override
        public void run(){

        }
    }
}
