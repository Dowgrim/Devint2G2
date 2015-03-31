package action;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 31/03/2015.
 */
public class Action {

    protected static ArrayList<Image> IMAGES;

    protected int image;

    protected int shiftX;

    protected int shiftY;

    protected int shiftWidth;

    protected int shiftHeigt;

    public static void initIMAGES(String chemin){

    }

    public Action(){
        image = 0;
        shiftHeigt = 0;
        shiftWidth = 0;
        shiftX = 0;
        shiftY = 0;
    }


    public int getShiftX() {
        return shiftX;
    }

    public int getShiftY() {
        return shiftY;
    }

    public int getShiftWidth() {
        return shiftWidth;
    }

    public int getShiftHeigt() {
        return shiftHeigt;
    }

    public Image getImage() {
        return IMAGES.get(image);
    }

    public void forward() {
        image++;
    }
}
