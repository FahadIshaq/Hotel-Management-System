package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Roommenu extends JFrame {

    private Booking book;
    private Room room;
    private JLabel n, text, l1, l2, l3, l4, l5, l6, l7, l8, label;
    private JTextField f1, f2, f3, f4;
    private JButton b1, b2, b3, b4, back, submit;
    private ImageIcon i;
    private JPanel p1, p2;


    public Roommenu(Booking be) {
        setSize(1300, 700);
        setLocation(25, 25);
        i = new ImageIcon(ClassLoader.getSystemResource("pics/home.png"));
        n = new JLabel(i);
        text = new JLabel("FXR HOTELS ");
        text.setBounds(18, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);
        add(n);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 70));
        book = new Booking(be);


        label = new JLabel("ROOM BOOKING MENU");
        label.setBounds(530, 10, 700, 40);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        n.add(label);


        l3 = new JLabel("   3) Luxury Single Room");
        b3 = new JButton("L/S ROOM DETAILS");
        l4 = new JLabel("   4) Luxury Double Room");
        b4 = new JButton("L/D ROOM DETAILS");
        l1 = new JLabel("   1) Deluxe Single Room");
        b1 = new JButton("D/S ROOM DETAILS");
        l2 = new JLabel("   2) Deluxe Double Room");
        b2 = new JButton("D/D ROOM DETAILS");
        l5 = new JLabel("   ENTER ROOM OPTION (1/2/3/4): ");
        f1 = new JTextField(20);
        l6 = new JLabel("   ENTER STAY DURATION");
        f2 = new JTextField(20);
        l7 = new JLabel("   WIFI SERVICE (Y/N) ?");
        f3 = new JTextField(20);
        l8 = new JLabel("   TV IN ROOM (Y/N)? ");
        f4 = new JTextField(20);


        back = new JButton("BACK");
        back.setBounds(600, 580, 100, 50);

        submit = new JButton("SUBMIT");
        submit.setBounds(750, 580, 100, 50);

        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);


        p1 = new JPanel();
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p1.setLayout(new GridLayout(8, 2));
        p1.add(l1);
        p1.add(b1);
        p1.add(l2);
        p1.add(b2);
        p1.add(l3);
        p1.add(b3);
        p1.add(l4);
        p1.add(b4);
        p1.add(l5);
        p1.add(f1);
        p1.add(l6);
        p1.add(f2);
        p1.add(l7);
        p1.add(f3);
        p1.add(l8);
        p1.add(f4);


        n.add(back);
        n.add(submit);
        n.add(text);


        p1.setBounds(500, 60, 500, 500);
        n.add(p1, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Mylistener a = new Mylistener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);


    }

    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == back) {
                dispose();
                if (book.roomarray.isEmpty() == true) {
                    dispose();

                    RegisterationPanel r = new RegisterationPanel();

                } else {
                    Menu2 customermenu = new Menu2(book);
                }
            }
            if (a.getSource() == submit) {
                boolean condition = true;
                String ph = f1.getText() + f2.getText();

                int ph_count = 0; //checking text box 4.
                for (int n = ph.length(); n > 0; n--) {
                    char c = ph.charAt(n - 1);//get a single character of the string
                    if ((Character.isAlphabetic(c) || c == ' ')) {//if its an alphabetic character or white space
                        ph_count++;
                    }
                }
                if (ph.isBlank() || (ph_count != 0 && ph.length() < 11)) {
                    condition = false;

                }
                if (!(f3.getText().equalsIgnoreCase("y") || f3.getText().equalsIgnoreCase("n") || f4.getText().equalsIgnoreCase("y") || f4.getText().equalsIgnoreCase("n"))) {
                    condition = false;

                }

                if (condition == true) {


                    if (book.roomarray.isEmpty() == true) {
                        dispose();
                    }
                    if (f1.getText().equals("1")) {
                        room = new DeluxeSingleRoom();
                        room.setroomfare(1500);
                        int num = setRoomN("1");
                        room.setnumberofrooms();
                        room.setroomno(num);

                    }
                    if (f1.getText().equals("2")) {
                        room = new DeluxeDoubleRoom();
                        room.setroomfare(2500);
                        int num = setRoomN("2");
                        room.setnumberofrooms();
                        room.setroomno(num);
                    }
                    if (f1.getText().equals("3")) {
                        room = new LuxurySingleRoom();
                        room.setroomfare(2000);
                        int num = setRoomN("3");
                        room.setnumberofrooms();
                        room.setroomno(num);


                    }
                    if (f1.getText().equals("4")) {
                        room = new LuxuryDoubleRoom();
                        room.setroomfare(4000);
                        int num = setRoomN("4");
                        room.setnumberofrooms();
                        room.setroomno(num);

                    }
                    room.noofdaysofstay = Integer.parseInt(f2.getText());
                    if (f3.getText().equals("Y") || f3.getText().equals("y")) {
                        room.haswifi = true;
                    } else {
                        room.haswifi = false;
                    }
                    if (f4.getText().equals("Y") || f4.getText().equals("y")) {
                        room.hastv = true;
                    } else {
                        room.hastv = false;
                    }
                    if (book.roomarray.isEmpty() == false) {
                        JOptionPane.showMessageDialog(null, "ROOM BOOKED! \nYOUR BOOKED ROOM IS: " + room.getroomno());
                        book.roomarray.add(room);
                        Booking.updateroombooking(book);
                        Menu2 menu = new Menu2(book);

                    } else if (book.getRegisteredstatus() == true && book.roomarray.isEmpty() == true) {
                        book.roomarray.add(room);
                        Booking.updateroombooking(book);
                        JOptionPane.showMessageDialog(null, "ROOM BOOKED! \nYOUR BOOKED ROOM IS: " + room.getroomno());
                        Menu2 menu = new Menu2(book);

                    } else {
                        book.roomarray.add(room);
                        book.setregisteredstatus(true);
                        Booking.addBooking(book);
                        JOptionPane.showMessageDialog(null, "ROOM BOOKED! \nYOUR BOOKED ROOM IS: " + room.getroomno());
                        Menu2 menu = new Menu2(book);

                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "INVALID INPUT");

                }
            }else {
                    if (a.getSource()==b3)
                        JOptionPane.showMessageDialog(null, LuxurySingleRoom.LuxurySingleRoomDetails());
                    if (a.getSource()==b4)
                        JOptionPane.showMessageDialog(null, LuxuryDoubleRoom.LuxuryDoubleRoomDetails());
                    if (a.getSource()==b1)
                        JOptionPane.showMessageDialog(null, DeluxeSingleRoom.DeluxeSingleRoomDetails());
                    if (a.getSource()==b2)
                        JOptionPane.showMessageDialog(null, DeluxeDoubleRoom.DeluxeDoubleRoomDetails());

                }


            }

        }

        public int setRoomN(String st) {
            int roomx = 0;
            if (st.equals("1")) {
                int[] roomno = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                for (int i = 0; i < roomno.length; i++) {
                    if (Booking.searchroomno(roomno[i]) == true) {
                        roomx = roomno[i];
                        break;
                    }
                }
            }
            if (st.equals("2")) {
                int[] roomno = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
                for (int i = 0; i < roomno.length; i++) {
                    if (Booking.searchroomno(roomno[i]) == true) {
                        roomx = roomno[i];
                        break;
                    }
                }
            }
            if (st.equals("3")) {
                int[] roomno = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
                for (int i = 0; i < roomno.length; i++) {
                    if (Booking.searchroomno(roomno[i]) == true) {
                        roomx = roomno[i];
                        break;
                    }
                }
            }
            if (st.equals("4")) {
                int[] roomno = {31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
                for (int i = 0; i < roomno.length; i++) {
                    if (Booking.searchroomno(roomno[i]) == true) {
                        roomx = roomno[i];
                        break;
                    }
                }
            }
            return roomx;
        }


    }

