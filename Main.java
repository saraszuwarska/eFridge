import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {

        /*
         * // JLabel = Display area for string of text, image or both ImageIcon ficon =
         * new ImageIcon("fridge_icon.png"); Border border =
         * BorderFactory.createLineBorder(Color.white, 3);
         * 
         * JLabel label = new JLabel(); // creating label
         * label.setText("Ingredients in:"); // set text of label label.setIcon(ficon);
         * label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER or
         * RIGHT of image icon label.setVerticalTextPosition(JLabel.TOP);
         * label.setFont(new Font("MV Boli", Font.PLAIN, 20));
         * label.setForeground(Color.white); label.setBorder(border);
         * label.setVerticalAlignment(JLabel.CENTER);
         * label.setHorizontalAlignment(JLabel.CENTER);
         */

        // JPanel = component that functions as a container to hold other components
        JLabel label = new JLabel();
        label.setText("Hello!");

        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.red);
        redpanel.setBounds(0, 0, 250, 250);

        JPanel bluepanel = new JPanel();
        bluepanel.setBackground(Color.blue);
        bluepanel.setBounds(250, 0, 250, 250);

        JPanel yellowpanel = new JPanel();
        yellowpanel.setBackground(Color.yellow);
        yellowpanel.setBounds(0, 250, 500, 250);

        MyFrame myFrame = new MyFrame();
        redpanel.add(label);
        myFrame.add(redpanel);
        myFrame.add(bluepanel);
        myFrame.add(yellowpanel);

    }
}