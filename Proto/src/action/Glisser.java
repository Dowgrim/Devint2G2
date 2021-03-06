package action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Glisser extends Action {

    protected static ArrayList<Image> IMAGES = new ArrayList<Image>();

    private int time = 0;

    public Glisser(){
        shiftY = 260;
        shiftHeigt = -300;
        shiftWidth = 50;
    }

    @Override
    public void forward(){
        time ++;
        if(time == 300){
            endAction = true;
        }
    }

    public static void initIMAGES(String chemin){
        File f = new File("./images/colo/glisse2.png");
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
