package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Foodmenu extends JFrame {

    protected Booking book;
    protected Food food;
    private ImageIcon i;
    private JLabel n,text,l1,l2,l3,l4,l5,l6,l7,label;
    private JButton b1,b2,b3,b4,back,submit;
    private JTextField f1,f2,f3;
    private JPanel p1;
    public Foodmenu(Booking be) {

        setSize(1300, 700);
        setLocation(25, 25);
        i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
        n = new JLabel(i);
        text = new JLabel("FXR HOTELS ");
        text.setBounds(18, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);

        label= new JLabel("FOOD MENU");
        label.setBounds(590, 10, 700, 40);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        add(n);
        n.add(text);
        n.add(label);

        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD, 70));



        book = new Booking(be);
        l1 = new JLabel("1) BREAKFAST");
        b1 = new JButton("BREAKFAST MENU");
        l2 = new JLabel("2) LUNCH");
        b2 = new JButton("LUNCH MENU");
        l3 = new JLabel("3) DINNER");
        b3 = new JButton("DINNER MENU");
        l4 = new JLabel("4) OTHER FOOD");
        b4 = new JButton("OTHER MENU");
        l5 = new JLabel("ENTER YOUR CHOICE(1/2/3/4): ");
        f1 = new JTextField(20);
        l6 = new JLabel("ENTER QUANTITY OF CHOOSED FOOD: ");
        f2 = new JTextField(20);
        l7 = new JLabel("ENTER YOUR FOOD CHOICE(1-9): ");
        f3 = new JTextField(20);

         p1 = new JPanel();


        p1.setLayout(new GridLayout(7,2));
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


        p1.setBounds(480,80,500,500);
        n.add(submit);
        n.add(back);

        n.add(p1);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Mylistener a = new Mylistener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        back.addActionListener(a);
        submit.addActionListener(a);
    }
    public class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent a ) {
            if(a.getSource()==back) {
                dispose();
                Menu2 c1 = new Menu2(book);
            }
            if(a.getSource()==submit) {
                //CHECK
                String choice = f2.getText() + f3.getText();
                boolean opt = false;

                for (int i = 0; i < choice.length(); i++) {
                    if (choice.charAt(i) == '1' || choice.charAt(i) == '2' || choice.charAt(i) == '3' || choice.charAt(i) == '4' || choice.charAt(i) == '5' || choice.charAt(i) == '6' || choice.charAt(i) == '7' || choice.charAt(i) == '8' || choice.charAt(i) == '9') {
                        opt = true;
                    } else {
                        opt = false;

                    }
                }
                if (f1.getText() != null && (f1.getText().equals("1") || f1.getText().equals("2") || f1.getText().equals("3") || f1.getText().equals("4")) && opt == true) {

                    double z = prices(f1.getText(), f3.getText());

                    if (f1.getText().equals("1")) {
                        food = new Breakfast(z, Integer.parseInt(f3.getText()), Integer.parseInt(f2.getText()));
                    }
                    if (f1.getText().equals("2")) {
                        food = new Lunch(z, Integer.parseInt(f3.getText()), Integer.parseInt(f2.getText()));
                    }
                    if (f1.getText().equals("3")) {
                        food = new Dinner(z, Integer.parseInt(f3.getText()), Integer.parseInt(f2.getText()));
                    }
                    if (f1.getText().equals("4")) {
                        food = new Otherfood(z, Integer.parseInt(f3.getText()), Integer.parseInt(f2.getText()));
                    }
                    JOptionPane.showMessageDialog(null, "FOOD BILL = " + food.getcost());
                    book.customer.foodarray.add(food);
                    Booking.updateroombooking(book);
                    JOptionPane.showMessageDialog(null, "ORDER DONE");
                    dispose();
                    Menu2 back = new Menu2(book);

                }else{
                    JOptionPane.showMessageDialog(null,"INVALAID FILL");

                }
            }

            else {
                if(a.getActionCommand().equals("BREAKFAST MENU"))
                    JOptionPane.showMessageDialog(null,Breakfast.Breakfastoptions());
                if(a.getActionCommand().equals("LUNCH MENU"))
                    JOptionPane.showMessageDialog(null,Lunch.Lunchoptions());
                if(a.getActionCommand().equals("DINNER MENU"))
                    JOptionPane.showMessageDialog(null,Dinner.Dinneroptions());
                if(a.getActionCommand().equals("OTHER MENU"))
                    JOptionPane.showMessageDialog(null,Otherfood.Otherfoodoptions());

            }
        }

        public double prices(String x,String y) {
            double price = 0;
            if(x.equals("1")) {
                if(y.equals("1"))
                    price = 300;
                if(y.equals("2"))
                    price = 400;
                if(y.equals("3"))
                    price = 250;
            }
            if(x.equals("2")) {
                if(y.equals("1"))
                    price = 200;
                if(y.equals("2"))
                    price = 500;
                if(y.equals("3"))
                    price = 450;

            }
            if(x.equals("3")) {
                if(y.equals("1"))
                    price = 300;
                if(y.equals("2"))
                    price = 350;
                if(y.equals("3"))
                    price = 450;

            }
            if(x.equals("4")) {
                if(y.equals("1"))
                    price = 100;
                if(y.equals("2"))
                    price = 50;
                if(y.equals("3"))
                    price = 100;
                if(y.equals("4"))
                    price = 1500;
            }
            return price;
        }

    }

}
