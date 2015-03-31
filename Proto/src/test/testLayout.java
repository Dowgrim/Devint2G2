package test;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Michael on 31/03/2015.
 */
public class testLayout {

    public testLayout() {
        JFrame f = new JFrame("TEST");
        f.setSize(400, 400);
        JPanel contentPane = new JPanel();
        f.setContentPane(contentPane);
        contentPane.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final testPanel tP = new testPanel();
        contentPane.add(tP);
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

                }
            }
        });
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new testLayout();
    }

}
