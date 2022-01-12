package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu2 extends JFrame {
    private JButton button1, button2, button3, button4, button5, button6;
    private JLabel n, l3,l2;
    private ImageIcon i;

     Booking book;


    public Menu2(Booking b) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1300, 700);
        setLocation(25, 25);
         i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        n = new JLabel(i);
        book = new Booking(b);

         l2 = new JLabel("FXR HOTELS ");

        l2.setBounds(20, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);

        add(n);
        l3 = new JLabel("CUSTOMER OPTIONS");
        l3.setBounds(520, 20, 420, 100);
        l3.setFont(new Font("serif", Font.BOLD, 35));
        l3.setForeground(Color.BLACK);


        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));


        button1 = new JButton("ORDER FOOD");
        button2 = new JButton("LANDARY CLEANING");
        button3 = new JButton("CHECKOUT");

        button5 = new JButton("GENERATE BILL");
        button6 = new JButton("BOOK ANOTHER ROOM");



        button4 = new JButton("LOGOUT");
        button1.setBounds(600, 100, 200, 70);
        button2.setBounds(600, 180, 200, 70);
        button3.setBounds(600, 260, 200, 70);
        button5.setBounds(600, 340, 200, 70);
        button6.setBounds(600, 420, 200, 70);

        button4.setBounds(600, 500, 200, 70);

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
        n.add(l3);

        setLayout(null);
        setVisible(true);
        Mylistener m = new Mylistener();
        button1.addActionListener(m);
        button3.addActionListener(m);
        button5.addActionListener(m);
        button2.addActionListener(m);
        button4.addActionListener(m);
        button6.addActionListener(m);


    }

    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == button4) {
                dispose();
                CustomerLogin loginmenu=new CustomerLogin();
            }
            if (a.getSource()==button6){
                dispose();
                Roommenu bookroom=new Roommenu(book);

            }
            else if (a.getSource()==button1){
                dispose();

                Foodmenu orderFood=new Foodmenu(book);

            }
            else if(a.getSource()==button2){
                dispose();
                Laundarymenu r=new Laundarymenu(book);

            }
            else if (a.getSource()==button3){
                book.setCheckoutstatus(true);
                Booking.updateroombooking(book);
                JOptionPane.showMessageDialog(null,book.customer.tostring()+"\nFOOD DETAILS: \nNUMBER OF FOOD ORDERS : "+book.customer.foodarray.size()+"\nFOOD BILL : "+ book.customer.calculatetotalfoodbill()+"\nLAUNDRY BILL :\nNUMBER OF LAUNDRY ORDERS : "+book.customer.laundryarray.size()+"\nLAUNDRY BILL : "+book.customer.calculatetotallaundarybill()+"\nROOM DETAILS :\nNUMBER OF ROOMS BOOKED : "+book.roomarray.size()+"\nROOM BILL : "+book.calculatetotalpriceofstay()+"\nTOTAL BILL : "+book.totalstaybill());

            }
            else if (a.getSource()==button5){
                JOptionPane.showMessageDialog(null,"FOOD DETAILS\nNUMBER OF FOOD ORDERS : "+book.customer.foodarray.size()+"\nFOOD BILL : "+ book.customer.calculatetotalfoodbill()+"\nLAUNDRY DETAILS\nNUMBER OF LAUNDRY ORDERS :  "+book.customer.laundryarray.size()+"\nLAUNDRY BILL : "+book.customer.calculatetotallaundarybill()+"\nROOM DETAILS\nNUMBER OF ROOMS BOOKED : "+book.roomarray.size()+"\nROOM BILL : "+book.calculatetotalpriceofstay());

            }

        }
    }
}
