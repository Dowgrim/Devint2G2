package action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 31/03/2015.
 */
public class Courir extends Action {

    private static ArrayList<Image> IMAGES = new ArrayList<Image>();

    private int interval = 0;



    @Override
    public void forward(){
       interval++;
        if(interval == 20){
            if(image == 7){
                image = 0;
            }
            image++;
            interval = 0;
        }

    }

    public static void initIMAGES(String chemin){
        File f;
        if(chemin.equals("troll")){
            for(int i = 1; i <= 10; i++){
                f = new File("./images/Perso/frame-"+i+".gif");
                try {
                    IMAGES.add(ImageIO.read(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
                for (int i = 1; i <= 8; i++) {
                    f = new File("./images/colo/course" + i + ".png");
                    try {
                        IMAGES.add(ImageIO.read(f));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    @Override
    public Image getImage() {
        return IMAGES.get(image);
    }
}
