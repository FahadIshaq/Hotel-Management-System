package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ShowCustomers extends JFrame{
    private ImageIcon i;
    private JLabel n,l2,label;
    private JTable table;
    private JScrollPane p;
    private JButton back,submit;

    public ShowCustomers(){

        ArrayList<Booking> list=new ArrayList<Booking>();

        setSize(1300, 700);
        setLocation(25, 25);

        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Hoteltext.dat"));
            while (true){
                Booking d= (Booking) input.readObject();
                list.add(d);
                System.out.println(d.toString());
            }
        }
        catch (EOFException e1){
            System.out.println("End of File");
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        String[] columns={"USER-NAME","MOBILE NUMBER","CNIC"};

        String [][]data=new String[list.size()][columns.length];


        for (int j=0; j<list.size(); j++) {
            if(list.get(j).getRegisteredstatus()==true) {
                data[j][0] = list.get(j).customer.getName();
                data[j][1] = list.get(j).customer.getMobileno();
                data[j][2] = list.get(j).customer.getCnic();
            }
        }
         i = new ImageIcon(ClassLoader.getSystemResource("pics/adminloginn.png"));
         n = new JLabel(i);
        l2 = new JLabel("FXR HOTELS ");
        l2.setBounds(20, 450, 788, 234);
        n.setBounds(0, 0, 1300, 700);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));
        table = new JTable(data, columns);

        table.setFillsViewportHeight(true);
        table.setBounds(200,150,700,400);
         p=new JScrollPane(table);
        p.setBounds(300,100,700,400);
        add(n);

        label= new JLabel("CUSTOMERS  RECORD");
        label.setBounds(430, 50, 700, 40);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);


        back=new JButton("BACK");
        back.setBounds(550,530,100,50);

        submit=new JButton("EXIT");
        submit.setBounds(670,530,100,50);

        back.setFont(new Font("serif", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);

        n.add(back);
        n.add(submit);

        n.add(p);
        n.add(l2);
        n.add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        MyListener m=new MyListener();
        submit.addActionListener(m);
        back.addActionListener(m);

    }
    public class MyListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            if (e.getSource()==back){
                dispose();
                AdminOptions backption=new AdminOptions();
            }else if (e.getSource()==submit){
                dispose();
                System.exit(0);

            }
        }
    }

}
