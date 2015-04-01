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
        shiftY = 100;
        shiftHeigt = -100;
        shiftWidth = +100;
    }

    @Override
    public void forward(){
        time ++;
        if(time == 500){
            endAction = true;
        }

    }

    public static void initIMAGES(String chemin){
        File f = new File("./Proto/images/Perso/5pivo.png");
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
