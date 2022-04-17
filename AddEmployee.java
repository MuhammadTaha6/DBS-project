package com.company;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JButton b1;
    JComboBox c1;

    AddEmployee(){
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("serif", Font.PLAIN, 16));
        name.setBounds(60,30,120,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(150,30,150,30);
        add(t1);

        JLabel age = new JLabel("Age:");
        age.setFont(new Font("serif", Font.PLAIN, 16));
        age.setBounds(60,80,120,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(150,80,150,30);
        add(t2);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("serif", Font.PLAIN, 16));
        gender.setBounds(60,130,120,30);
        add(gender);

        r1 = new JRadioButton("Male:");
        r1.setFont(new Font("serif", Font.PLAIN, 15));
        r1.setBounds(150,130,80,30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female:");
        r2.setFont(new Font("serif", Font.PLAIN, 15));
        r2.setBounds(230,130,80,30);
        r2.setBackground(Color.WHITE);
        add(r2);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);

        JLabel job = new JLabel("Job:");
        job.setFont(new Font("serif", Font.PLAIN, 16));
        job.setBounds(60,180,120,30);
        add(job);

        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff",
                "Room Service","Waiter/Waitress", "Manager","Accountant","Chef"};
        c1 = new JComboBox(str);
        c1.setBounds(150,180,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel salary = new JLabel("Salary:");
        salary.setFont(new Font("serif", Font.PLAIN, 16));
        salary.setBounds(60,230,120,30);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(150,230,150,30);
        add(t3);

        JLabel phone = new JLabel("Phone:");
        phone.setFont(new Font("serif", Font.PLAIN, 16));
        phone.setBounds(60,280,120,30);
        add(phone);

        t4 = new JTextField();
        t4.setBounds(150,280,150,30);
        add(t4);

        JLabel cnic = new JLabel("CNIC:");
        cnic.setFont(new Font("serif", Font.PLAIN, 16));
        cnic.setBounds(60,330,120,30);
        add(cnic);

        t5 = new JTextField();
        t5.setBounds(150,330,150,30);
        add(t5);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("serif", Font.PLAIN, 16));
        email.setBounds(60,380,120,30);
        add(email);

        t6 = new JTextField();
        t6.setBounds(150,380,150,30);
        add(t6);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150,430,150,30);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/teeth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(340,80,400,400);
        add(l1);

        JLabel l2 = new JLabel("Add Employee Details");
        l2.setForeground(Color.BLUE);
        l2.setBounds(370,10,400,60);
        l2.setFont(new Font("Tahoma", Font.PLAIN,40));
        add(l2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400,170,800,520);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String cnic = t5.getText();
        String email = t6.getText();
        String gender = null;

        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }

        String job = (String)c1.getSelectedItem();

        conn c = new conn();
        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"'," +
                " '"+phone+"','"+cnic+"', '"+email+"')";

        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            setVisible(false);
        }catch (Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args){
        new AddEmployee();
    }
}