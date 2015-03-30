package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 06/03/2015.
 */
public class ViewLevel extends JFrame implements Observer {

    private ViewPlayer player;

    private ArrayList<ViewObstacle> obstacles;

    private ArrayList<Item> items;

    private BackGroundL backGround;

    public ViewLevel(){
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new test());
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player.setAction("Sauter");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player.setAction("Glisser");
                }

            }
        });
        backGround = new BackGroundL();
        setContentPane(backGround);

        player = new ViewPlayer();

        obstacles = new ArrayList<ViewObstacle>();

        setVisible(true);

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
