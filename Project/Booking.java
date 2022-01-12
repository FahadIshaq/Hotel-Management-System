package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.*;
import java.util.ArrayList;

public class Booking implements Serializable {
    Customer customer;
    ArrayList<Room> roomarray = new ArrayList();
    private String checkindate;
    private double totalpriceofstay;
   private boolean staybeforecheck;
    private boolean registeredstatus;
    private boolean checkoutstatus;
    public Booking() {

    }
    public Booking(Customer x) {
        customer = new Customer(x);
    }
    Booking(Booking b) {
        this.customer = b.customer;
        this.roomarray = b.roomarray;
        this.checkindate = b.checkindate;
        this.totalpriceofstay = b.totalpriceofstay;
        this.staybeforecheck = b.staybeforecheck;
        this.registeredstatus = b.registeredstatus;
        this.checkoutstatus = b.checkoutstatus;
    }
    public void setcustomer(Customer x) {
        customer = new Customer(x);
    }
    public void setregisteredstatus(boolean x) {
        registeredstatus = x;
    }
    public int searchroom(int x) {
        int check = -1;
        for(Room i : roomarray) {
            if(i.getRoomno() == x) {
                check = roomarray.indexOf(i);
                break;
            }
        }
        return check;
    }

    public void removeroom(int x) {
        for(Room i : roomarray) {
            if(i.getRoomno() == x) {
                roomarray.remove(i);
            }
        }
    }
    public static void addBooking(Booking s) {
        try
        {
            File f = new File("Hoteltext.dat");

            ObjectOutputStream oos;
            if(f.exists())
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        }
        catch (IOException e){
            System.out.println(e.toString()+" Exception Occured");

        }

    }
    public static ArrayList<Booking> readFile( ){
        ArrayList<Booking> list = new ArrayList<Booking>();
        try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Hoteltext.dat"));
            while(true)
            {
                Booking obj = ( Booking) input.readObject();
                list.add(obj);
            }
        }
        catch ( Exception c){
            System.out.println(c.toString()+ "Exception");

        }
        return list;
    }
    public static Booking searchBooking(String x, int y) {
        boolean check = false;
        Booking st = new Booking();
        ArrayList<Booking> list = Booking.readFile();
        for(Booking i : list) {
            if(i.customer.getName().equals(x)) {
                for(Room z : i.roomarray) {
                    if(z.getRoomno() == y) {
                        check = true;
                        break;
                    }
                }
            }
            if(check == true) {
                st = i;
                break;
            }
        }
        return st;
    }

    public static void deleteBooking(String x, int y) {
        ArrayList<Booking> list = Booking.readFile();
        boolean check = false;
        for(Booking i : list) {
            if(i.customer.getName().equals(x)) {
                for(Room z : i.roomarray) {
                    if(z.getRoomno() == y) {
                        check = true;
                        break;
                    }
                }
            }
            if(check == true) {
                list.remove(i);
                break;
            }
        }
        try {
            File f = new File("Hoteltext.dat");
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(f));
            for(Booking s: list){
                o.writeObject(s);
            }
            o.close();
        }
        catch(Exception e){
            System.out.println(e.toString()+ "Exception Occured");

        }

    }

    public static void updateBooking(Booking book) {
        ArrayList<Booking> list = Booking.readFile();
        boolean check = false;
        for(Booking i : list) {
            if(i.customer.getName().equals(book.customer.getName()) && i.customer.getCnic().equals(book.customer.getCnic())) {
                int list1 = book.roomarray.get(0).getroomno();
                int list2 = i.roomarray.get(0).getroomno();
                if(list1 == list2) {
                    int index = list.indexOf(i);
                    list.set(index, book);
                }
            }

        }
        try {
            File f = new File("Hoteltext.dat");
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(f));
            for(Booking s: list){
                o.writeObject(s);
            }
            o.close();
        }
        catch(Exception e){
            System.out.println(e.toString()+" Exception Occured");

        }
    }
    public static void updateroombooking(Booking book) {
        ArrayList<Booking> list = Booking.readFile();
        boolean check = false;
        for (Booking i : list) {
            if (i.customer.getName().equals(book.customer.getName()) && i.customer.getCnic().equals(book.customer.getCnic())) {
                if (i.customer.foodarray.size() == book.customer.foodarray.size() || i.customer.laundryarray.size() == book.customer.laundryarray.size()) {
                    int index = list.indexOf(i);
                    list.set(index, book);
                }
            }

        }
        try {
            File f = new File("Hoteltext.dat");
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(f));
            for (Booking s : list) {
                o.writeObject(s);
            }
            o.close();
        } catch (Exception e) {
            System.out.println(e.toString()+ "Exception Occured");

        }
    }

    public static String displayalldata() {
        String st = " ";
        int i = 0;
        ArrayList<Booking> aa= Booking.readFile();
        for( Booking stud:aa){
            i++;
            st += i+") NAME : "+stud.customer.getName()+"  CONTACT NUMBER : "+stud.customer.getMobileno()+"  ROOM NUMBER : "+stud.roomarray.get(0).getRoomno()+"  BILL : "+stud.totalstaybill()+"\n";
        }
        return st;
    }
    public static boolean searchroomno(int x) {
        boolean check = true;
        ArrayList<Booking> list= Booking.readFile();
        if(list.isEmpty()) {
            check = true;
        }
        else {
            for( Booking i : list){
                ArrayList<Room> roomlist = i.roomarray;
                for(Room j : roomlist) {
                    if(j.getRoomno() == x) {
                        check = false;
                        break;
                    }
                }
                if(check == false) {
                    break;
                }
            }
        }
        return check;
    }

    public double calculatetotalpriceofstay() {
        double total = 0;
        for(Room i : roomarray) {
            if(i instanceof DeluxeSingleRoom) {
                total = total + (i.noofdaysofstay * i.getroomfare());
            }
            if(i instanceof DeluxeDoubleRoom) {
                total = total + (i.noofdaysofstay * i.getroomfare());
            }
            if(i instanceof LuxurySingleRoom) {
                total = total + (i.noofdaysofstay * i.getroomfare());
            }
            if(i instanceof LuxuryDoubleRoom) {
                total = total + (i.noofdaysofstay * i.getroomfare());
            }
        }
        return totalpriceofstay = total;
    }
    public double totalstaybill() {
        return customer.calculatetotalfoodbill() + customer.calculatetotallaundarybill() + calculatetotalpriceofstay();
    }

    public boolean getCheckoutstatus() {
        return checkoutstatus;
    }

    public boolean getRegisteredstatus() {
        return registeredstatus;
    }

    public void setCheckoutstatus(boolean b) {
        checkoutstatus=b;
    }
}
