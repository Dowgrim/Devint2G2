package action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 31/03/2015.
 */
public class Glisser extends Action {

    protected static ArrayList<Image> IMAGES = new ArrayList<Image>();

    private int time = 0;


    public Glisser(){
        shiftY = 280;
        shiftHeigt = -350;
    }

    @Override
    public void forward(){
        time ++;
        if(time == 300){
            endAction = true;
        }

    }

    public static void initIMAGES(String chemin){
        File f = new File("./images/colo/glisse1.png");
        try {
            IMAGES.add(ImageIO.read(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImage() {
        return IMAGES.get(image);
    }
}
