package modele;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Michael on 06/03/2015.
 */
public class Level extends Observable {
    private int position;
    ArrayList<Obstacle> obstacles;
}
