package eFridge;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    JLabel name;
    JLabel quantity;
    JLabel alertquantity;
    JPanel listpanel;
    String[] categories = { "WARZYWA", "OWOCE", "MIESO", "RYBY", "NABIAL", "NAPOJE", "SLODYCZE", "PRZEKASKI",
            "PRZYPRAWY", "SOSY" };
    JComboBox kategorieMenu;

    Frame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 500);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setTitle("e-Fridge");
        this.setVisible(true);
    }

    public void adding(Product product) {
        listpanel = new JPanel();
        listpanel.setBackground(Color.gray);
        listpanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        listpanel.setBounds(2, 2, 150, 300);

        name = new JLabel();
        name.setText(product.name);
        name.setHorizontalAlignment(JLabel.LEFT);
        name.setVerticalAlignment(JLabel.TOP);

        quantity = new JLabel();
        quantity.setText(product.quantity.toString());
        quantity.setHorizontalAlignment(JLabel.LEFT);
        quantity.setVerticalAlignment(JLabel.TOP);

        alertquantity = new JLabel();
        alertquantity.setText(product.alertQuantity.toString());
        alertquantity.setHorizontalAlignment(JLabel.LEFT);
        alertquantity.setVerticalAlignment(JLabel.TOP);

        kategorieMenu = new JComboBox(categories);
        kategorieMenu.addActionListener(this);

        listpanel.add(name);
        listpanel.add(quantity);
        listpanel.add(alertquantity);
        this.add(listpanel);
        this.add(kategorieMenu);

        revalidate();
    }

    public void categorySelect(ActionEvent e) {
        if (e.getSource() == kategorieMenu) {
            kategorieMenu.getSelectedIndex();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        categorySelect(e);
    }

}
