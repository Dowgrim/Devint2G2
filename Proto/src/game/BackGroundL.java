package game;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 25/03/2015.
 */
public class BackGroundL extends JPanel{

    private Image background;
    private String backgroundPath;

    public BackGroundL(String backGround) {
        this.backgroundPath = backGround;
        File f = new File(backGround);
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BackGroundL(JSONObject backGround){
        File f = new File(backGround.getString("image"));
    }

    public void setImage(String image){
        File f = new File(image);
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(), getHeight());
        g.drawImage(background, 0, 0, 7000, 750, null);
        g.drawImage(background, 7000, 0, 7000, 750, null);
    }

    public void forward(int pos){
        setBounds(-(pos % 7000), 0, 9000, 750);
    }
    
    public JSONObject toJson(){
        JSONObject back = new JSONObject();
        back.put("image", backgroundPath);
        return back;
    }
}
