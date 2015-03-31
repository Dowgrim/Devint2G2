package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 25/03/2015.
 */
public class BackGroundL extends JPanel implements Observer{

    private Image background;

    private int position;

    public BackGroundL(){
        this.setLayout(null);

        File f = new File("./images/5.jpg");
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        g.drawImage(background, position-3500, 0, 3500, 750, null);
        g.drawImage(background, position, 0, 3500, 750, null);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
