package action;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 31/03/2015.
 */
public class Action {

    private int image;

    private int shiftX;

    private int shiftY;

    private int shiftWidth;

    private int shiftHeigt;

    private ArrayList<Image> images;


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
        return images.get(image);
    }

    public void forward() {
    }
}
