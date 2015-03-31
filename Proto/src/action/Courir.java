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
        super.forward();
        if(interval == 10){
            image++;
            interval = 0;
        }

    }

    public static void initIMAGES(String chemin){
        File f;
        if(chemin.equals("troll")){
            for(int i = 1; i <= 10; i++){
                f = new File("./Proto/images/Perso/frame-"+i+".gif");
                try {
                    IMAGES.add(ImageIO.read(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            for(int i = 1; i <= 6; i++){
                f = new File("./Proto/images/Perso/"+i+".gif");
                try {
                    IMAGES.add(ImageIO.read(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
