package com.company;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame {

    public AddCustomer() throws SQLException {

        setBounds(370, 160, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);

        JLabel l = new JLabel("NEW CUSTOMER FORM");
        l.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        l.setBounds(118, 11, 260, 53);
        contentPane.add(l);

        JLabel l2 = new JLabel("ID :");
        l2.setBounds(35, 76, 200, 14);
        contentPane.add(l2);

        comboBox = new JComboBox(new String[] {"Passport", "CNIC", "Driving license"});
        comboBox.setBounds(271, 73, 150, 20);
        contentPane.add(comboBox);

        JLabel l3 = new JLabel("Number :");
        l3.setBounds(35, 111, 200, 14);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel l4 = new JLabel("Name :");
        l4.setBounds(35, 151, 200, 14);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);


        JLabel l5 = new JLabel("Gender :");
        l5.setBounds(35, 191, 200, 14);
        contentPane.add(l5);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        add(r2);

        JLabel l6 = new JLabel("Country :");
        l6.setBounds(35, 231, 200, 14);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Allocated Room Number :");
        l7.setBounds(35, 274, 200, 14);
        contentPane.add(l7);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while(rs.next()){
                c1.add(rs.getString("room_number"));
            }
        }catch(Exception e){ }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);

        JLabel l8 = new JLabel("Checked-In :");
        l8.setBounds(35, 316, 200, 14);
        contentPane.add(l8);

        JLabel l9 = new JLabel("Deposit :");
        l9.setBounds(35, 359, 200, 14);
        contentPane.add(l9);

        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JButton l10 = new JButton("Add");
        l10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                String radio = null;

                if(r1.isSelected()){
                    radio = "Male";
                }
                else if(r2.isSelected()){
                    radio = "Female";
                }

                String s6 = c1.getSelectedItem();

                try{

                    String s1 = (String)comboBox.getSelectedItem();
                    String s2 =  t1.getText();
                    String s3 =  t2.getText();
                    String s4 =  radio;
                    String s5 =  t3.getText();
                    String s7 =  t5.getText();
                    String s8 =  t6.getText();

                    String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                    String q2 = "update room set availability = 'Occupied' where room_number = "+s6;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);


                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
                catch(NumberFormatException s){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        l10.setBounds(100, 430, 120, 30);
        l10.setBackground(Color.BLACK);
        l10.setForeground(Color.WHITE);
        contentPane.add(l10);

        JButton l11 = new JButton("Back");
        l11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        l11.setBounds(260, 430, 120, 30);
        l11.setBackground(Color.BLACK);
        l11.setForeground(Color.WHITE);
        contentPane.add(l11);

        getContentPane().setBackground(Color.WHITE);
    }
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    JComboBox comboBox;
    JRadioButton r1,r2;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCustomer frame = new AddCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
