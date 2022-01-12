package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

public class AdminSearch extends JFrame {
    private String str;
    private JLabel l1, l3, l2, n;
    private JTextField t1, t2;
    private JButton b1, b2;
    private ImageIcon i, i1, i3;
    private Image i2;


    public AdminSearch(String st) {
        str = st;

        setSize(1300, 700);
        setLocation(25, 25);

        i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        n = new JLabel(i);
        l2 = new JLabel("FXR HOTELS ");
        l2.setBounds(18, 450, 788, 250);
        n.setBounds(0, 0, 1300, 700);
        add(n);
        n.add(l2);

        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));


        l3 = new JLabel("CUSTOMER SEARCH");
        l3.setBounds(500, 120, 700, 40);

        l3.setFont(new Font("Arial", Font.BOLD, 40));

        l1 = new JLabel("USERNAME");
        l1.setBounds(500, 200, 100, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 17));

        l1.setForeground(Color.BLACK);
        n.add(l1);

        l2 = new JLabel("ROOM NO.");
        l2.setBounds(500, 250, 100, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);

        n.add(l2);

        t1 = new JTextField();
        t1.setBounds(650, 200, 150, 30);
        n.add(t1);

        t2 = new JTextField();
        t2.setBounds(650, 250, 150, 30);
        n.add(t2);
        n.add(l3);
        i1 = new ImageIcon(ClassLoader.getSystemResource("pics/loginn.png"));
        i2 = i1.getImage().getScaledInstance(250, 310, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(840, 197, 150, 150);
        n.add(l3);


        b1 = new JButton("Search");
        b1.setBounds(670, 300, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        n.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(530, 300, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        n.add(b2);
        getContentPane().setBackground(Color.WHITE);
        n.add(l2);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Mylistener m = new Mylistener();

        b1.addActionListener(m);
        b2.addActionListener(m);


    }

    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == b2) {
                dispose();
                AdminOptions h1 = new AdminOptions();
            }
            if (a.getSource() == b1) {
                String ph = t1.getText();
                String k = t2.getText();

                int ph_count = 0; //checking text box 4.
                for (int n = ph.length(); n > 0; n--) {
                    char c = ph.charAt(n - 1);//get a single character of the string
                    if ((Character.isDigit(c) || c == ' ')) {//if its an alphabetic character or white space
                        ph_count++;
                    }

                }
                for (int n = k.length(); n > 0; n--) {
                    char c = k.charAt(n - 1);//get a single character of the string
                    if ((Character.isAlphabetic(c) || c == ' ')) {//if its an alphabetic character or white space
                        ph_count++;
                    }

                }
                if (ph_count == 0) {
                    String x = t1.getText();
                    int y = Integer.parseInt(t2.getText());
                    Booking book = Booking.searchBooking(x, y);
                    if (book.customer != null) {
                        if (str.equals("SHOW CUSTOMER")) {
                            JOptionPane.showMessageDialog(null, Booking.displayalldata());

                        } else if (str.equals("DELETE BOOKING RECORD")) {
                            Booking.deleteBooking(x, y);
                            JOptionPane.showMessageDialog(null, "BOOKING DELETED");
                        } else if (str.equals("SEARCH BOOKING")) {
                            JOptionPane.showMessageDialog(null, book.customer.tostring() + "\nFood details: \nNo of food orders = " + book.customer.foodarray.size() + "\nFood bill = " + book.customer.calculatetotalfoodbill() + "\nLaundary details :\nNo of Laundary orders =  " + book.customer.laundryarray.size() + "\nLaundary bill = " + book.customer.calculatetotallaundarybill() + "\nRoom details :\nNo of booked rooms = " + book.roomarray.size() + "\nRoom bill = " + book.calculatetotalpriceofstay() + "\nTotal Bill = " + book.totalstaybill());

                        } else if (str.equals("CANCEL ROOM")) {
                            dispose();
                            Roomcancellationframe cancelRoom = new Roomcancellationframe(book);

                        } else if (str.equals("CANCEL FOOD ORDER")) {
                            if (book.customer.foodarray.size() != 0) {
                                int i = book.customer.foodarray.size();
                                book.customer.foodarray.remove(i - 1);
                                Booking.updateroombooking(book);
                                JOptionPane.showMessageDialog(null, "FOOD ORDER HAS BEEN CANCELLED");

                            } else {
                                JOptionPane.showMessageDialog(null, "NO FOOD ORDER FOUND");

                            }
                        } else if (str.equals("CANCEL LAUNDRY ORDER")) {
                            if (book.customer.laundryarray.size() != 0) {
                                int i = book.customer.laundryarray.size();
                                book.customer.laundryarray.remove(i - 1);
                                Booking.updateroombooking(book);
                                JOptionPane.showMessageDialog(null, "LAUNDARY HAS BEEN CANCELLED");
                            } else {
                                JOptionPane.showMessageDialog(null, "NO LAUNDARY ORDER FOUND");

                            }

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "CUSTOMER NOT FOUND");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID INPUT");

                }
            }
        }
    }
}
