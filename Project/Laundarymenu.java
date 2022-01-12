package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Laundarymenu extends JFrame {

    private Booking book;
    private JLabel l,l1,l2,l3,l4;
    private JTextField f1,f2,f3,f4;

    private Food food;
    private ImageIcon i;
    private JLabel n,text,label;
    private JButton back,submit;
    private JPanel p1;
    public Laundarymenu(Booking bt) {

        setSize(1300, 700);
        setLocation(25, 25);
        i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        n = new JLabel(i);
        text = new JLabel("FXR HOTELS ");
        text.setBounds(18, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);

        label= new JLabel("LAUNDRY MENU");
        label.setBounds(570, 10, 700, 40);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        add(n);
        n.add(text);
        n.add(label);

        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 70));


        book = new Booking(bt);

        l1 = new JLabel("   ENTER NUMBER OF SHIRTS: : ");
        f1 = new JTextField(20);
        l2 = new JLabel("   ENTER NUMBER OF PANTS : ");
        f2 = new JTextField(20);
        l3 = new JLabel("   ENTER NUMBER OF COATS : ");
        f3 = new JTextField(20);
        l4 = new JLabel("   Enter NUMBER OF OTHER CLOTHES: ");
        f4 = new JTextField(20);
         p1 = new JPanel();


        p1.setLayout(new GridLayout(4,2));
        p1.add(l1);
        p1.add(f1);
        p1.add(l2);
        p1.add(f2);
        p1.add(l3);
        p1.add(f3);
        p1.add(l4);
        p1.add(f4);
        p1.setBounds(480,80,500,500);
        back=new JButton("BACK");
        back.setBounds(620,600,100,50);

        submit=new JButton("SUBMIT");
        submit.setBounds(770,600,100,50);

        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        n.add(back);
        n.add(submit);


        n.add(p1,BorderLayout.CENTER);
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
             Menu2 back=new Menu2(book);

            }
            if(a.getSource()==submit) {
                boolean condition=true;
                String ph = f1.getText()+f2.getText()+f3.getText()+f4.getText();

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
                if (condition==true) {
                    if (book.customer != null) {

                        Laundary l1 = new Laundary(Integer.parseInt(f1.getText()), Integer.parseInt(f2.getText()), Integer.parseInt(f3.getText()), Integer.parseInt(f4.getText()));
                        JOptionPane.showMessageDialog(null, "Laundary Bill = " + l1.calculatePrice());
                        book.customer.laundryarray.add(l1);
                        Booking.updateroombooking(book);
                        JOptionPane.showMessageDialog(null, "ORDER DONE");
                        Menu2 back = new Menu2(book);

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "INVALID INPUT");

                }

            }

        }

    }


}
