package modele;

import static org.junit.Assert.*;

import game.Obstacle;
import game.ObstacleCarac;
import org.json.JSONObject;
import org.junit.Test;

public class testObstacle {

    @Test
    public void testToJson() {
        ObstacleCarac obstacle = new ObstacleCarac(25,30,18,17);
        JSONObject json = new JSONObject("{\"posX\":25,\"posY\":30,\"width\":18,\"height\":17}");
        assertEquals(obstacle.toJson().toString(),json.toString());
    }
    
    @Test
    public void testToJsonNegative(){
        ObstacleCarac obstacle = new ObstacleCarac(-16,-19,-18,-17);
        JSONObject json = new JSONObject("{\"posX\":16,\"posY\":19,\"width\":18,\"height\":17}");
        assertEquals(obstacle.toJson().toString(),json.toString());
    }
    
    @Test
    public void testRetourMemeObjet(){
        ObstacleCarac obstacle = new ObstacleCarac(0,0,0,0);
        ObstacleCarac obstacle2 = new ObstacleCarac(0,0,0,0);
        assertEquals(obstacle,obstacle2);
        obstacle.setPosX(1);
        assertTrue(!obstacle.equals(obstacle2));
        obstacle.setPosX(0);
        assertEquals(obstacle,obstacle2);
    }
    
    @Test
    public void testSetNegative(){
        ObstacleCarac obstacle = new ObstacleCarac(-14,-13,-25,-28);
        ObstacleCarac obstacle2 = new ObstacleCarac(14,13,25,28);
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
