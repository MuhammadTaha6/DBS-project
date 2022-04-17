package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){
        mb = new JMenuBar();
        mb.setBounds(0,0,1540,30);
        add(mb);

        m1 = new JMenu("Hotel Management");
        m1.setForeground(Color.BLACK);
        mb.add(m1);

        m2 = new JMenu("Admin");
        m2.setForeground(Color.BLACK);
        mb.add(m2);

        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,805,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1540,805);
        add(l1);

        JLabel l2 = new JLabel("THE MAS GROUP WELCOMES YOU");
        l2.setBounds(430,60,1000,50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.PLAIN, 42   ));
        l1.add(l2);

        setLayout(null);
        setBounds(0,0,1540,825);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reception")) {
            new Reception().setVisible(true);
        } else if (ae.getActionCommand().equals("Add Employee")) {
            new AddEmployee().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Rooms")) {
            new AddRooms().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}

