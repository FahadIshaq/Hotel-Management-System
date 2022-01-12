package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel extends JFrame {
    private ImageIcon i;
    private JButton b;
    private JLabel n,l2,l3;
    public Hotel() {
        setSize(1300, 700);
        setLocation(25, 25);
         i = new ImageIcon(ClassLoader.getSystemResource("pics/home.png"));
         n = new JLabel(i);
         l2 = new JLabel("FXR HOTELS ");
        l2.setBounds(18, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);

        add(n);


         l3 = new JLabel("WELCOME  TO  OUR  HOTEL");
        l3.setBounds(300, 110, 1000, 50);
l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial", Font.BOLD, 55));

      n.add(l3);



        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));
         b = new JButton("CLICK HERE TO CONTINUE");
        b.setBounds(810, 550, 350, 50);
        b.setFont(new Font("Arial", Font.BOLD, 18));
        b.setBackground(new Color(239, 188, 2));
        b.setForeground(Color.BLACK);
        n.add(l2);
        n.add(b);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        MyListener m=new MyListener();
        b.addActionListener(m);

    }

    public class MyListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            if (e.getActionCommand().equals("CLICK HERE TO CONTINUE")){
                dispose();
                BothPanles b=new BothPanles();
            }
        }
        }

}

