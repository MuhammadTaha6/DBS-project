package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Reception  extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

    Reception(){
        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(10,30,200,30);
        add(b1);

        b2 = new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(10,70,200,30);
        add(b2);

        b3 = new JButton("All Employee info ");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(10,110,200,30);
        add(b3);

        b4 = new JButton("Customer info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.setBounds(10,150,200,30);
        add(b4);

        b5 = new JButton("Manager info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        b5.setBounds(10,190,200,30);
        add(b5);

        b6 = new JButton("Checkout");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        b6.setBounds(10,230,200,30);
        add(b6);

        b7 = new JButton("Logout");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        b7.setBounds(10,270,200,30);
        add(b7);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(250,30,400,270);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setBounds(430,170,700,370);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try {
                new AddCustomer().setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.setVisible(false);

        }else if(ae.getSource() == b2){
            new Room().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource() == b3){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource() == b4){
            try {
                new CustomerInfo().setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.setVisible(false);

        }else if(ae.getSource() == b5){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource() == b6){
            try {
                new Checkout().setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.setVisible(false);

        }else if(ae.getSource() == b7){
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new Reception();
    }
}
