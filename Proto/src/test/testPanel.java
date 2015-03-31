package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 31/03/2015.
 */
public class testPanel extends JPanel {

    Image image = null;

    public testPanel(){
        this.setLayout(null);

        File f = new File("./Proto/images/Perso/5.gif");
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, 100, 100, null);
    }
}
