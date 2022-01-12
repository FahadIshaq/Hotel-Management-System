package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AdminOptions extends JFrame {

    private JButton button1, button2, button3, button4, button5, button6,button7;
    private JLabel n, l3,l2;
    private ImageIcon i;


    public AdminOptions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1300, 700);
        setLocation(25, 25);
         i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        n = new JLabel(i);


        l2 = new JLabel("FXR HOTELS ");

        l2.setBounds(20, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);

        add(n);
        l3=new JLabel("ADMIN OPTIONS");
        l3.setBounds(550,20,350,100);
        l3.setFont(new Font("serif", Font.BOLD, 35));
        l3.setForeground(Color.black);


        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));


        button1 = new JButton("SHOW COSTUMERS");
        button2 = new JButton("SEARCH BOOKING");
        button3 = new JButton("DELETE BOOKING RECORD");

        button5 = new JButton("CANCEL ROOM");
        button6 = new JButton("CANCEL FOOD ORDER");
        button7=new JButton("CANCEL LAUNDRY ORDER");



        button4 = new JButton("LOGOUT");
        button1.setBounds(600, 100, 200, 70);
        button2.setBounds(600, 180, 200, 70);
        button3.setBounds(600, 260, 200, 70);
        button5.setBounds(600, 340, 200, 70);
        button6.setBounds(600, 420, 200, 70);

        button7.setBounds(600, 500, 200, 70);
        button4.setBounds(600, 580, 200, 70);
        button7.setBorder(BorderFactory.createLineBorder(Color.blue));
        button7.setBackground(Color.BLACK);
        button7.setForeground(Color.white);

        button1.setBorder(BorderFactory.createLineBorder(Color.blue));
        button2.setBorder(BorderFactory.createLineBorder(Color.blue));
        button3.setBorder(BorderFactory.createLineBorder(Color.blue));
        button5.setBorder(BorderFactory.createLineBorder(Color.blue));
        button6.setBorder(BorderFactory.createLineBorder(Color.blue));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.white);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.white);
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.white);
        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.white);
        button6.setBackground(Color.BLACK);
        button6.setForeground(Color.white);

        n.add(l2);
        n.add(button1);
        n.add(button2);
        n.add(button3);
        n.add(button4);
        n.add(button5);
        n.add(button6);
        n.add(button7);
        n.add(l3);

        setLayout(null);
        setVisible(true);
        Mylistener m=new Mylistener();

        button1.addActionListener(m);
        button3.addActionListener(m);
        button5.addActionListener(m);
        button6.addActionListener(m);
        button2.addActionListener(m);
        button4.addActionListener(m);
        button6.addActionListener(m);
        button7.addActionListener(m);

    }

    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if(a.getSource()==button4) {
                dispose();
                AdminLogin h=new AdminLogin();
            }
            if(a.getSource()==button3) {
               AdminSearch s=new AdminSearch("DELETE BOOKING RECORD");
                dispose();
            }
            if (a.getSource()==button5){
               AdminSearch s=new AdminSearch("CANCEL ROOM");
                dispose();
            }
            if (a.getSource()==button1){
                dispose();
                ShowCustomers s=new ShowCustomers();

            }
            if (a.getSource()==button2){

                AdminSearch s=new AdminSearch("SEARCH BOOKING");
                dispose();

            }
            if (a.getSource()==button6){
                AdminSearch s=new AdminSearch("CANCEL FOOD ORDER");
                dispose();

            }
            if (a.getSource()==button7){
                AdminSearch s=new AdminSearch("CANCEL LAUNDRY ORDER");
                dispose();

            }
        }
    }
}
