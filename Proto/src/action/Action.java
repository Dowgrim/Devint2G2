package action;

import java.awt.*;
import java.util.ArrayList;

import org.json.JSONObject;

/**
 * Created by Michael on 31/03/2015.
 */
public class Action {

    protected int image;

    protected int shiftX;

    protected int shiftY;

    protected int shiftWidth;

    protected int shiftHeigt;

    protected int interval;

    protected boolean endAction = false;

    public Action(){
        interval = 0;
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
        return null;
    }

    public boolean isEndAction() {
        return endAction;
    }

    public void forward() { }
    
    /**
     * an action in a toJson
     * @return a JSONObject representing the instance of Action
     */
    public JSONObject toJson(){
        JSONObject actionJson = new JSONObject();
        actionJson.put("image",image);
        actionJson.put("shiftX",shiftX);
        actionJson.put("shiftY",shiftY);
        actionJson.put("shiftWidth",shiftWidth);
        actionJson.put("shiftHeight",shiftHeigt);
        return actionJson;
    }
}
