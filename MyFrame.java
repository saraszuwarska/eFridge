import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyFrame() {

        this.setTitle("Desktop Fridge");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // hide_on_close is on default
        this.setResizable(true);// unresizable

        this.setSize(500, 500);// size: x-dimension, y-dimension
        this.setVisible(true); // make frame visible

        ImageIcon image = new ImageIcon("fridge_icon.png"); // create icon
        this.setIconImage(image.getImage()); // change frame icon
        this.getContentPane().setBackground(new Color(0x123456)); // background color change, RGB or hex values
    }

}
