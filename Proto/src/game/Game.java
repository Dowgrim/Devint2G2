package game;

import action.Courir;
import action.Glisser;
import action.Sauter;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Michael on 25/03/2015.
 */
public class Game {

    private static String DATA = "chemon vers les données";

    private Difficulty difficulty = Difficulty.VeryEasy;
    private Level level;


    public Game(){
        Courir.initIMAGES("TODO");
        Glisser.initIMAGES("TODO");
        Sauter.initIMAGES("TODO");
        launchLevel(1);
    }


    public void launchLevel(int l) {
        //TODO
        //Aller regardez dans DATA le chemin vers le fichier de donnée du Level l.
        // lancer le niveau
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(1300, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(2400, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(3000, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(3600, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(5000, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(6200, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(7000, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(8000, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(8300, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        obstacles.add(new Obstacle("./Proto/images/Obstacle/lion.jpeg", new ObstacleCarac(9000, 350, 200, 100), KeyEvent.VK_UP, "./Proto/sons/lion.wav"));
        level = new Level(obstacles, difficulty);
    }

    public static void main(String[] args) {
        new Game();
    }

}