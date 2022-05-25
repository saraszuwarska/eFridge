package eFridge;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GenerateWindow extends JFrame {
    JFrame frame = new JFrame();
    JLabel category1 = new JLabel("Nazwa:");

    GenerateWindow() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(750, 500);
        this.getContentPane().setBackground(new Color(0x123456));
        category1.setFont(new Font(null));
        category1.setForeground(Color.WHITE);
        this.add(category1);

        this.setVisible(true);
    }

}
