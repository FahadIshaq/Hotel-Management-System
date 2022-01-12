package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Roomcancellationframe extends JFrame {
    private Booking book;
    private JLabel n,l2,l3,b;
    private JTextField f1;
    private JButton submit,back;
    private ImageIcon i;
    public Roomcancellationframe(Booking be) {
        book = new Booking(be);
        setSize(1300, 700);
        setLocation(25, 25);
         i = new ImageIcon(ClassLoader.getSystemResource("pics/home.png"));
         n = new JLabel(i);
         l2 = new JLabel("FXR HOTELS ");
        l2.setBounds(18, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);
        add(n);

        l3 = new JLabel("ROOM CANCELLATION");
        l3.setBounds(500, 150, 1000, 40);

        l3.setFont(new Font("Arial", Font.BOLD, 40));

        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));
         b = new JLabel("ENTER ROOM NUMBER ");
        b.setBounds(640, 290, 350, 50);
        b.setFont(new Font("Arial", Font.BOLD, 18));
        b.setBackground(new Color(239, 188, 2));
        b.setForeground(Color.BLACK);

        back = new JButton("BACK");
        back.setBounds(600, 430, 120, 30);
        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        submit = new JButton("SUBMIT");
        submit.setBounds(730, 430, 120, 30);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);

        f1 = new JTextField(20);
        f1.setBounds(640,340,200,30);

        n.add(back);
        n.add(submit);
        n.add(l3);




        n.add(l2);
        n.add(b);



        n.add(f1);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Mylistener a = new Mylistener();
        back.addActionListener(a);
        submit.addActionListener(a);

    }


    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a ) {
            if(a.getSource()==back) {
                dispose();
                AdminOptions options=new AdminOptions();


            }
            if(a.getSource()==submit) {
                int index = book.searchroom(Integer.parseInt(f1.getText()));
                if(index != -1){
                    book.roomarray.remove(index);
                    if(book.roomarray.size() != 0) {
                        Booking.updateBooking(book);
                        JOptionPane.showMessageDialog(null,"ROOM BOOKING CANCELLED");
                    }
                    else {
                        dispose();
                        JOptionPane.showMessageDialog(null,"ROOM BOOKING CANELLED");
AdminOptions OPTIONS=new AdminOptions();

                    }

                }
                else {
                    JOptionPane.showMessageDialog(null,"WRONG ROOM NUMBER!");
                    AdminOptions OPTIONS=new AdminOptions();

                }

            }


        }

    }

}
