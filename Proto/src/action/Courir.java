package action;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Michael on 31/03/2015.
 */
public class Courir extends Action {

    private static ArrayList<Image> IMAGES;

    private int interval = 0;

    @Override
    public void forward(){
        interval++;
        if(interval == 10){
            image++;
            interval = 0;
        }

    }
}
