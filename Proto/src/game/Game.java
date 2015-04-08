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
        Courir.initIMAGES("PetiteFille");
        Glisser.initIMAGES("lol");
        Sauter.initIMAGES("lol");
        launchLevel(1);
    }


    public void launchLevel(int l) {
        //TODO
        //Aller regardez dans DATA le chemin vers le fichier de donnée du Level l.
        // lancer le niveau
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        int tailleLion = 250;
        int tailleAigle = 100;
        int posLion = 470;
        int posAigle = 300;
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(1300, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/aigle.png", new ObstacleCarac(2400, posAigle, tailleAigle, tailleAigle), KeyEvent.VK_DOWN, "./sons/aigle.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(3000, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(3600, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(5000, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(6200, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/aigle.png", new ObstacleCarac(7000, posAigle, tailleAigle, tailleAigle), KeyEvent.VK_DOWN, "./sons/aigle.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(8000, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/aigle.png", new ObstacleCarac(8300, posAigle, tailleAigle, tailleAigle), KeyEvent.VK_DOWN, "./sons/aigle.wav"));
        obstacles.add(new Obstacle("./images/Obstacle/lion.png", new ObstacleCarac(9000, posLion, tailleLion, tailleLion), KeyEvent.VK_UP, "./sons/lion.wav"));
        level = new Level(obstacles, difficulty);
    }

    public static void main(String[] args) {
        new Game();
    }

}