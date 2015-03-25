package modele;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class testObstacle {

    @Test
    public void testToJson() {
        Obstacle obstacle = new Obstacle(25,30,18,17);
        JSONObject json = new JSONObject("{\"posX\":25,\"posY\":30,\"width\":18,\"height\":17}");
        assertEquals(obstacle.toJson().toString(),json.toString());
    }
    
    @Test
    public void testToJsonNegative(){
        Obstacle obstacle = new Obstacle(-16,-19,-18,-17);
        JSONObject json = new JSONObject("{\"posX\":16,\"posY\":19,\"width\":18,\"height\":17}");
        assertEquals(obstacle.toJson().toString(),json.toString());
    }
    
    @Test
    public void testRetourMemeObjet(){
        Obstacle obstacle = new Obstacle(0,0,0,0);
        Obstacle obstacle2 = new Obstacle(0,0,0,0);
        assertEquals(obstacle,obstacle2);
        obstacle.setPosX(1);
        assertTrue(!obstacle.equals(obstacle2));
        obstacle.setPosX(0);
        assertEquals(obstacle,obstacle2);
    }
    
    @Test
    public void testSetNegative(){
        Obstacle obstacle = new Obstacle(-14,-13,-25,-28);
        Obstacle obstacle2 = new Obstacle(14,13,25,28);
        assertEquals(obstacle,obstacle2);
        obstacle.setPosX(-12);
        obstacle2.setPosX(12);
        assertEquals(obstacle,obstacle2);
        obstacle.setPosY(-24);
        obstacle2.setPosY(24);
        assertEquals(obstacle,obstacle2);
        obstacle.setWidth(-69);
        obstacle2.setWidth(69);
        assertEquals(obstacle,obstacle2);
        obstacle.setHeight(-42);
        obstacle2.setHeight(42);
        assertEquals(obstacle,obstacle2);
    }

}
