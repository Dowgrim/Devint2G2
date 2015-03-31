package modele;

import static org.junit.Assert.*;

import game.Player;
import game.PlayerCarac;
import org.junit.Test;

public class testPlayer {

    @Test
    public void testConstructor() {
        int life = 8;
        PlayerCarac player = new PlayerCarac(life);
        assertEquals(player.getLife(),life);
        assertEquals(player.getMAXLIFE(),life);
        assertEquals(player.getMAXLIFE(),player.getLife());
        assertEquals(player.getScore(),0);
        assertTrue(!player.isDead());
    }
    
    @Test
    public void testEquals(){
        //new Player() equals new Player()
        PlayerCarac player = new PlayerCarac();
        PlayerCarac player2 = new PlayerCarac();
        assertEquals(player,player2);
        //player life = 1 != player2 life = 2
        player2.setLife(2);
        player.setLife(1);
        assertTrue(!player.equals(player2));
        //score
        int score = 28;
        player.setScore(score);
        assertEquals(player.getScore(),score);
    }
    
    @Test
    public void testBorder(){
        //life < 0
        PlayerCarac player = new PlayerCarac(-9);
        assertTrue(player.getLife()>0);
        //life << 0
        player.setLife(-20000);
        assertTrue(player.isDead());
        //life = 0
        player.setLife(0);
        assertTrue(player.isDead());
        //score<<0
        player.setScore(-29049089);
        assertTrue(player.getScore()==0);
    }

}
