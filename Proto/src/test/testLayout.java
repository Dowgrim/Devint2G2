package test;

import game.BackGroundL;
import game.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 31/03/2015.
 */
public class testLayout extends JPanel{

    Image image;

    public testLayout() {
        File f = new File("./images/BackGround/5.jpg");
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("TEST");
        f.setSize(400, 400);

        JPanel contentPane = new JPanel();
        f.setContentPane(contentPane);

        final Player tP = new Player(0);

        contentPane.add(tP);

        final BackGroundL layoutpane = new BackGroundL("./Proto/images/BackGround/5.jpg");
        contentPane.add(layoutpane);

        layoutpane.setBounds(0,0,f.getWidth(), f.getHeight());

        contentPane.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tP.setBounds(50, 50, 100, 100);
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP :{
                        tP.setBounds(tP.getX(), tP.getY()-1, tP.getWidth(), tP.getHeight());
                        break;
                    }
                    case KeyEvent.VK_DOWN :{
                        tP.setBounds(tP.getX(), tP.getY()+1, tP.getWidth(), tP.getHeight());
                        break;
                    }
                    case KeyEvent.VK_LEFT :{
                        tP.setBounds(tP.getX()-1, tP.getY(), tP.getWidth(), tP.getHeight());
                        break;
                    }
                    case KeyEvent.VK_RIGHT :{
                        tP.setBounds(tP.getX()+1, tP.getY(), tP.getWidth(), tP.getHeight());
                        break;
                    }
                    case KeyEvent.VK_Z :{
                        layoutpane.setBounds(layoutpane.getX(), layoutpane.getY()-1, layoutpane.getWidth(), layoutpane.getHeight());
                        break;
                    }
                    case KeyEvent.VK_S :{
                        layoutpane.setBounds(layoutpane.getX(), layoutpane.getY()+1, layoutpane.getWidth(), layoutpane.getHeight());
                        break;
                    }
                    case KeyEvent.VK_Q :{
                        layoutpane.setBounds(layoutpane.getX()-1, layoutpane.getY(), layoutpane.getWidth(), layoutpane.getHeight());
                        break;
                    }
                    case KeyEvent.VK_D :{
                        layoutpane.setBounds(layoutpane.getX()+1, layoutpane.getY(), layoutpane.getWidth(), layoutpane.getHeight());
                        break;
                    }
                }
            }
        });
        f.setVisible(true);
    }

}
