package game;

import action.Courir;
import action.Glisser;
import action.Sauter;

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
    }


    public void launchLevel(int l){
        //TODO
        //Aller regardez dans DATA le chemin vers le fichier de donnée du Level l.
        // lancer le niveau
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        //obstacles.add(new Obstacle("./Proto/images/1.gif", new ObstacleCarac(1300, )));


    }
}