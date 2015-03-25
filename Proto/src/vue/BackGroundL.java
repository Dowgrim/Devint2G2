package vue;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 25/03/2015.
 */
public class BackGroundL extends JFrame implements Observer{

    private Image background;

    private int position;

    public BackGroundL(){

    }

    public void paint(Graphics g){

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
