package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainFrame extends JFrame{

        private JButton admin,back,exitt,customer;
        private JLabel n,l2,choose;
        private ImageIcon i;

        public CustomerMainFrame(){
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
            choose.setForeground(Color.BLACK);



            admin=new JButton("NEW CUSTOMER");
            choose.setBounds(550,170,700,120);
            admin.setBounds(820,300,250,50);
             customer=new JButton("LOG IN");
            customer.setBounds(550,300,250,50);

            admin.setForeground(Color.BLACK);
            admin.setFont(new Font("Arial", Font.BOLD, 18));
            admin.setBackground(new Color(239, 188, 2));

            customer.setForeground(Color.BLACK);
            customer.setFont(new Font("Arial", Font.BOLD, 18));
            customer.setBackground(new Color(239, 188, 2));
            back.setFont(new Font("serif", Font.BOLD, 15));
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            n.add(admin);
            n.add(customer);
            n.add(back);
            exitt.setFont(new Font("serif", Font.BOLD, 15));
            exitt.setBackground(Color.BLACK);
            exitt.setForeground(Color.WHITE);

            n.add(choose);
            n.add(exitt);

            setLayout(null);
            setVisible(true);
            MyListener m=new MyListener();

            back.addActionListener(m);
            exitt.addActionListener(m);
            admin.addActionListener(m);
            customer.addActionListener(m);



        }
        public class MyListener implements ActionListener {
            public void actionPerformed(ActionEvent e){

                if (e.getActionCommand().equals("NEW CUSTOMER")){
                    dispose();
             RegisterationPanel r=new RegisterationPanel();

                }
                if (e.getActionCommand().equals("LOG IN")){
                    dispose();
                    CustomerLogin n=new CustomerLogin();


                }
                if (e.getActionCommand().equals("BACK")){
                    BothPanles b=new BothPanles();
                    dispose();
                }
                else if(e.getActionCommand().equals("EXIT")){
                    dispose();
                    System.exit(0);

                }
            }
        }


    }

