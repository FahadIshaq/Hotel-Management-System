package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BothPanles extends JFrame {
    private JButton admin,back,exitt;
    private JButton customer;
    private ImageIcon i;
    private JLabel n,l2,choose;


    public BothPanles(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        back=new JButton("BACK");
        back.setBounds(700,400,100,50);

         exitt=new JButton("EXIT");
        exitt.setBounds(850,400,100,50);

        setSize(1300,700);
        setLocation(25,25);
         i=new ImageIcon(ClassLoader.getSystemResource("pics/home.png"));
         n=new JLabel(i);
        l2=new JLabel("FXR HOTELS ");
        l2.setBounds(18, 450, 788, 234);

        n.setBounds(0,0,1300,700);
        add(n);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.BOLD,70));

        choose=new JLabel("CHOOSE YOUR PANEL");
        choose.setFont(new Font("serif",Font.BOLD,50));

        n.add(l2);
        choose.setForeground(Color.black);


         admin=new JButton("ADMIN PANEL");
        choose.setBounds(550,170,700,120);
        admin.setBounds(820,300,250,50);
         customer=new JButton("CUSTOMER PANEL");
        customer.setBounds(550,300,250,50);

      admin.setForeground(Color.BLACK);
        admin.setFont(new Font("Arial", Font.BOLD, 18));
        admin.setBackground(new Color(239, 188, 2));

        customer.setForeground(Color.BLACK);
        customer.setFont(new Font("Arial", Font.BOLD, 18));
        customer.setBackground(new Color(239, 188, 2));

        n.add(admin);
        n.add(customer);
        n.add(back);
        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        exitt.setFont(new Font("serif", Font.BOLD, 15));
        exitt.setBackground(Color.BLACK);
        exitt.setForeground(Color.WHITE);

        n.add(choose);
        n.add(exitt);
        setLayout(null);
        setVisible(true);
        MyListener m=new MyListener();

        exitt.addActionListener(m);
        admin.addActionListener(m);
        customer.addActionListener(m);
        back.addActionListener(m);

    }
    public class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==admin){
                dispose();
                AdminLogin n=new AdminLogin();
            }
             else if (e.getSource()==customer){
                 dispose();
                 CustomerMainFrame bothOptions=new CustomerMainFrame();
            }
             if (e.getSource()==back){
                dispose();
                Hotel h=new Hotel();
            }
            else if(e.getActionCommand().equals("EXIT")){
                dispose();
                System.exit(0);
            }
        }
    }
}
