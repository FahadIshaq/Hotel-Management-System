package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {

    private JLabel l1, l3;
    private JTextField t1,t2;
    private JButton b1, b2;
    private ImageIcon i,i1,i3;
    private Image i2;

    public AdminLogin(){
        setSize(1300, 700);
        setLocation(25, 25);
        i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        JLabel n = new JLabel(i);
        JLabel l2 = new JLabel("FXR HOTELS ");
        l2.setBounds(18, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);
        add(n);
        n.add(l2);


        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));


        l3=new JLabel("ADMIN LOGIN");
        l3.setBounds(520,120,700,40);

        l3.setFont(new Font("Arial",Font.BOLD,40));

        l1 = new JLabel("USERNAME");
        l1.setBounds(500, 200, 100, 30);
        l1.setFont(new Font("Arial",Font.BOLD,17));

        l1.setForeground(Color.BLACK);
        n.add(l1);

        l2 = new JLabel("PASSWORD");
        l2.setBounds(500, 250, 100, 30);
        l2.setFont(new Font("Arial",Font.BOLD,17));
        l2.setForeground(Color.BLACK);

        n.add(l2);

        t1 = new JTextField();
        t1.setBounds(650, 200, 150, 30);
        n.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(650, 250, 150, 30);
        n.add(t2);
        n. add(l3);
         i1 = new ImageIcon(ClassLoader.getSystemResource("pics/ook.jpg"));
         i2 = i1.getImage().getScaledInstance(328, 410, Image.SCALE_DEFAULT);
         i3 = new ImageIcon(i2);
         l3 = new JLabel(i3);
        l3.setBounds(850, 140, 328, 410);
        n.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(670, 300, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        n.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(530, 300, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        n.add(b2);
        getContentPane().setBackground(Color.WHITE);
        n.add(l2);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    Mylistener m=new Mylistener();
        b1.addActionListener(m);
        b2.addActionListener(m);
    }
    public class Mylistener implements ActionListener {

    public void actionPerformed(ActionEvent a ) {
        if(a.getSource()==b2) {
            dispose();
          BothPanles home = new BothPanles();
        }
        if(a.getSource()==b1) {
            if(t1.getText().equals("admin") && t2.getText().equals("123")) {
                dispose();
                AdminOptions admin = new AdminOptions();

            }
            else {
                JOptionPane.showMessageDialog(null,"Try again. Wrong username or Password");
            }
        }


    }
}

}
