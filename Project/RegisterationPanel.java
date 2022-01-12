package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegisterationPanel extends JFrame {
    private JLabel label1, label2, label3, label4, label5, n, l2,label;
    private JButton button1, button2;

    private JTextField username, cnic, phone, email, address;
    private ImageIcon i;
    private JPanel panel1;


    public RegisterationPanel() {
        setSize(1300, 700);
        setLocation(25, 25);
        i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        n = new JLabel(i);
        l2 = new JLabel("FXR HOTELS ");
        l2.setBounds(20, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);
        add(n);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));

        n.add(l2);
        label= new JLabel("REGISTRATION  MENU");
        label.setBounds(536, 60, 700, 40);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        n.add(label);


        label1 = new JLabel(" USER-NAME: ");
        username = new JTextField(10);

        label2 = new JLabel(" CNIC: ");
        cnic = new JTextField(10);

        label3 = new JLabel(" ADDRESS: ");
        address = new JTextField(10);

        label4 = new JLabel(" E-MAIL: ");
        email = new JTextField(10);

        label5 = new JLabel(" PHONE: ");
        phone = new JTextField(10);
        button1 = new JButton("BACK");

        button2 = new JButton("SUBMIT");
        panel1 = new JPanel();

        panel1.setLayout(new GridLayout(5, 2));
        panel1.add(label1);
        panel1.add(username);
        panel1.add(label2);
        panel1.add(cnic);

        panel1.add(label3);
        panel1.add(address);
        panel1.add(label4);
        panel1.add(email);
        panel1.add(label5);
        panel1.add(phone);


        panel1.setBounds(560, 120, 400, 400);
        button1.setBounds(660, 550, 100, 50);
        button1.setFont(new Font("serif", Font.BOLD, 15));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button2.setBounds(800, 550, 100, 50);
        button2.setFont(new Font("serif", Font.BOLD, 15));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        n.add(panel1);
        n.add(button1);
        n.add(button2);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Mylistener m = new Mylistener();
        button1.addActionListener(m);
        button2.addActionListener(m);
    }

    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == button1) {
                dispose();
                CustomerMainFrame bothoptions = new CustomerMainFrame();
            }
            if (a.getSource() == button2) {
                boolean condition = true;

                if (username.getText().isBlank() || cnic.getText().isBlank() || address.getText().isBlank() || email.getText().isBlank() || phone.getText().isBlank() || username.getText().contains(" ") || cnic.getText().contains(" ") || address.getText().contains(" ") || email.getText().contains(" ") || phone.getText().contains(" ")) {
                    JOptionPane.showMessageDialog(null, "INVALID FILL");

                    condition = false;

                } else {
                    //USER NAME CHECK
                    String string = username.getText();
                    int k = 0; //checking text box 1.
                    for (int n = string.length(); n > 0; n--) {
                        char c = string.charAt(n - 1);//get a single character of the string
                        System.out.println(c);
                        if (!(Character.isAlphabetic(c) || c == ' ')) {//if its an alphabetic character or white space
                            k++;
                        }
                    }
                    if (k != 0) {
                        JOptionPane.showMessageDialog(null, "INVALID USER-NAME");
                        condition = false;

                    }

                    //CNIC CHECK


                    String CNIC = cnic.getText();

                    int cnic_count = 0; //checking text box 4.
                    for (int n = CNIC.length(); n > 0; n--) {
                        char c = CNIC.charAt(n - 1);//get a single character of the string
                        System.out.println(c);
                        if ((Character.isAlphabetic(c) || c == ' ')) {//if its an alphabetic character or white space
                            cnic_count++;
                        }
                    }
                    if (cnic_count != 0 && CNIC.length() != 13) {
                        JOptionPane.showMessageDialog(null, "INVALID CNIC");
                        condition = false;

                    }


                    //EMAIL CHECK

                    String Email = email.getText();
                    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                    Pattern pat = Pattern.compile(emailRegex);

                    if (Email == null) {
                        JOptionPane.showMessageDialog(null, "INVALID EMAIL FORMAT");
                        condition = false;

                    } else if (pat.matcher(Email).matches() != true) {
                        JOptionPane.showMessageDialog(null, "INVALID EMAIL FORMAT");
                        condition = false;


                    }


                    //PHONE NUMBER CHECK
                    String ph = phone.getText();

                    int ph_count = 0; //checking text box 4.
                    for (int n = ph.length(); n > 0; n--) {
                        char c = ph.charAt(n - 1);//get a single character of the string
                        if ((Character.isAlphabetic(c) || c == ' ')) {//if its an alphabetic character or white space
                            ph_count++;
                        }
                    }
                    if (ph.isBlank() || (ph_count != 0 && ph.length() < 11)) {
                        JOptionPane.showMessageDialog(null, "INVALID PHONE NUMBER ");
                        condition = false;

                    }

                    if (condition == true) {
                        Customer cust = new Customer(username.getText(), cnic.getText(), address.getText(), email.getText(), phone.getText());
                        Booking book = new Booking(cust);
                        Booking.addBooking(book);
                        JOptionPane.showMessageDialog(null, "REGISTERED");
                        dispose();
                        Roommenu r = new Roommenu(book);

                    }
                }
            }
        }
    }
}


