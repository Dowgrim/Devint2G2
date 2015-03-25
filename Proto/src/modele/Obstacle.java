package modele;

/**
 * Created by Michael on 06/03/2015.
 */
public enum Obstacle {
    Lion(1,1,1,1),
    Turtle(0,0,0,0);



    public int posX;

    private int posY;

    private int width;

    private int height;

    private Obstacle(int x, int y, int w, int h){
        posX = x;
        posY = y;
        width = w;
        height = h;
    }
}
