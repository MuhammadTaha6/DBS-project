package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{

    Main(){
        setBounds(100,100,1366,535);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/project.jpeg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1366,535);
        add(l1);

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1070,450,150,30);
        b1.addActionListener(this);
        l1.add(b1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20,400,1000,90);
        l2.setFont(new Font("serif", Font.PLAIN, 70));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        setLayout(null);
        setVisible(true);

        while(true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new Main();
    }
}
