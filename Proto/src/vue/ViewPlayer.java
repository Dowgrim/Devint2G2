package vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 06/03/2015.
 */
public class ViewPlayer extends JPanel{

    private String action;

    private int image = 0;

    private HashMap<String, ArrayList<Image>> images;

    private int decalageX = 0;

    private int decalageY = 0;

    private int keyPressed;

    public ViewPlayer(){
        File f;
        Image i = null;
        ArrayList<Image> tempIm = new ArrayList<Image>();
        for(int j = 1; j <= 10; j++) {
            f = new File("./images/frame-" + j + ".gif");
            try {
                i = ImageIO.read(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            tempIm.add(i);
        }
        images.put("Courir", tempIm);
        images.put("Sauter", tempIm);
        images.put("Glisser", tempIm);
        action = "Courir";
    }

    public void paintComponent(Graphics2D g){
        int h  = getParent().getHeight();
        int w = getParent().getWidth();
        g.drawImage(images.get(action).get(image), (w/6), h*3/4, 50, h/4, null);
    }

    public void Avancer(){
        image++;
        switch(action){
            case "Glisser" :{
                decalageY++;
                break;
            }
            case "Sauter" :{
                if(decalageY<getParent().getHeight()/4) {
                    decalageY += 3;
                }
                else{
                    action = "Courir";
                }
                break;
            }
            case "Courir" :{

                break;
            }
        }
    }

    public String getAction() {
        return action;
    }

    public int getImage() {
        return image;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
