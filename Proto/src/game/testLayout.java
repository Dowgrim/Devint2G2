package game;

import javax.swing.*;
import java.awt.*;

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
        JButton lol = new JButton("LOL");
        contentPane.add(lol);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new testLayout();
    }

}
