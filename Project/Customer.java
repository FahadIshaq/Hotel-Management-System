package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
   private  String name;
    private String cnic;
    private String address;
    private String email;
    private String mobileno;
    ArrayList <Food> foodarray = new ArrayList();
    ArrayList <Laundary> laundryarray = new ArrayList();
    public String getName() {
        return name;
    }
    public String getCnic() {
        return cnic;
    }

    public String getMobileno() {
        return mobileno;
    }
    
    public Customer() {

    }
    public Customer(String a,String b,String c, String d,String e) {
        name = a;
        cnic = b;
        address = c;
        email = d;
        mobileno = e;
    }
    public Customer(Customer x){
        this.name = x.name;
        this.cnic = x.cnic;
        this.address = x.address;
        this.email = x.email;
        this.mobileno = x.mobileno;
    }
    public String tostring() {
        return "\nNAME : "+name+"\nCNIC : "+cnic+"\nADDRESS : "+address+"\nEMAIL : "+email+"\nPHOME NUMBER : "+mobileno;
    }
    public double calculatetotallaundarybill() {
        double total = 0;
        for(Laundary i : laundryarray) {
            total = total + i.calculatePrice();
        }
        return total;
    }
    public double calculatetotalfoodbill() {
        double total = 0;
        for(Food i : foodarray) {
            total = total + i.getcost();
        }
        return total;
    }

}
