package eFridge;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;

import java.awt.font.*;
import java.text.NumberFormat;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class LaunchWindow extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel left_list = new JPanel();
    JPanel buttons_panel = new JPanel();
    JPanel third_panel = new JPanel();

    JLabel list_tittle = new JLabel();
    JLabel shopping_list = new JLabel();

    Border tittle_border = BorderFactory.createLineBorder(Color.WHITE);

    JButton add_button = new JButton("DODAJ");
    JButton generate_button = new JButton("OBIAD");
    JButton save_button = new JButton("ZAPISZ");

    JLabel product_name = new JLabel();

    fridgelist nowaLista = new fridgelist();

    String[] categories_names = { "WARZYWA", "OWOCE", "MIESO", "RYBY", "NABIAŁ", "NAPOJE", "SLODYCZE", "PRZEKASKI",
            "PRZYPRAWY", "SOSY" };

    DefaultListModel<Product> listModel = new DefaultListModel<>();
    JList<Product> fullList = new JList<>(listModel);
    JScrollPane scrollPane = new JScrollPane(fullList);

    LaunchWindow() {
        // --- okno glowne ---

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 780);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xb2ac88));
        frame.setTitle("e-Fridge");

        // --- sample produkty --
        Product sample = new Product("MASŁO", "NABIAŁ", 2, 0);
        listModel.addElement(sample);
        Product sample2 = new Product("JAJA", "NABIAŁ", 10, 0);
        listModel.addElement(sample2);

        // --- lista w lodowce ---
        fullList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fullList.setVisibleRowCount(25);
        fullList.setBackground(Color.lightGray);
        fullList.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 25));
        fullList.addListSelectionListener(this);

        scrollPane.setPreferredSize(new Dimension(200, 300));
        scrollPane.setBackground(new Color(255, 255, 255, 60));

        left_list.setBackground(new Color(255, 255, 255, 70));
        left_list.setBounds(10, 10, 400, 730);
        left_list.setBorder(tittle_border);
        left_list.setLayout(new BorderLayout());

        list_tittle.setText("DOSTĘPNE PRODUKTY");
        list_tittle.setHorizontalAlignment(SwingConstants.CENTER);
        list_tittle.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 25));
        left_list.add(list_tittle, BorderLayout.NORTH);
        left_list.add(scrollPane, BorderLayout.CENTER);

        // ---panel guzików ---
        buttons_panel.setBackground(new Color(244, 228, 220, 80));
        buttons_panel.setBounds(420, 10, 320, 35);
        buttons_panel.setLayout(new FlowLayout());

        add_button.addActionListener(this);
        add_button.setFocusable(false);

        generate_button.addActionListener(this);
        generate_button.setFocusable(false);

        save_button.addActionListener(this);
        save_button.setFocusable(false);

        buttons_panel.add(add_button);
        buttons_panel.add(generate_button);
        buttons_panel.add(save_button);

        // ---panel zakupów ---
        third_panel.setBackground(new Color(190, 155, 123, 80));
        third_panel.setBounds(420, 100, 320, 650);
        third_panel.setBorder(tittle_border);
        third_panel.setLayout(new BorderLayout());

        shopping_list.setText("ZAKUPY");
        shopping_list.setBorder(tittle_border);
        shopping_list.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 25));
        shopping_list.setForeground(Color.white);
        shopping_list.setLabelFor(third_panel);
        shopping_list.setHorizontalAlignment(SwingConstants.CENTER);
        third_panel.add(shopping_list, BorderLayout.NORTH);

        frame.add(left_list);
        frame.add(buttons_panel);
        frame.add(third_panel);

        frame.setVisible(true);

    }

    public void listPrinter(fridgelist lista) { // left_center.removeAll();
        JLabel category1 = new JLabel("PRODUKT");
        JLabel category2 = new JLabel("ILOŚĆ");

        category1.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
        category1.setForeground(new Color(62, 78, 80));
        category1.setHorizontalAlignment(SwingConstants.LEFT);

        category2.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
        category2.setForeground(new Color(62, 78, 80));
        category2.setHorizontalAlignment(SwingConstants.SOUTH_EAST); //
        left_center.add(category1); // left_center.add(category2);

        for (Product p : lista.products) {
            System.out.println(p.name);
            JLabel name_label = new JLabel(p.name);
            JLabel quantity_label = new JLabel(p.quantity.toString());

            name_label.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
            quantity_label.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
            name_label.setHorizontalAlignment(SwingConstants.LEFT);
            name_label.setForeground(new Color(62, 78, 80));
            name_label.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 15));
            quantity_label.setHorizontalAlignment(SwingConstants.RIGHT);
            quantity_label.setForeground(new Color(62, 78, 80));
            quantity_label.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 15));
        }

        // left_center.add(name_label); // left_center.add(quantity_label); }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_button) {
            Product newItem = new Product();
            ImageIcon Icon = new ImageIcon("buttons_icon.png"); // creates icon

            NumberFormat format = NumberFormat.getInstance();
            NumberFormatter formatter = new NumberFormatter(format);
            formatter.setValueClass(Integer.class);
            formatter.setAllowsInvalid(false);
            formatter.setMinimum(0);
            formatter.setMaximum(Integer.MAX_VALUE);

            JTextField nameField = new JTextField();
            JFormattedTextField quantityField = new JFormattedTextField(formatter);
            JFormattedTextField aquantityField = new JFormattedTextField(formatter);
            JComboBox categoryField = new JComboBox(categories_names);
            Object[] message = { "NAZWA:", nameField, "KATEGORIA:", categoryField, "ILOŚĆ:", quantityField,
                    "PRZYPOMNIENIE PRZY ILOŚCI:", aquantityField };

            int option = JOptionPane.showConfirmDialog(null, message, "DODAJ PRODUKT", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, Icon);
            newItem.name = nameField.getText();
            newItem.category = (String) categoryField.getSelectedItem();
            newItem.quantity = Integer.valueOf(quantityField.getText());
            newItem.alertQuantity = Integer.valueOf(aquantityField.getText());
            listModel.addElement(newItem);
            // listPrinter(nowaLista);
            frame.setVisible(true);

        } else if (e.getSource() == generate_button) {
            GenerateWindow newWindow = new GenerateWindow();
        } else if (e.getSource() == save_button) {
            SaveWindow newWindow = new SaveWindow();
        }
    }
}
