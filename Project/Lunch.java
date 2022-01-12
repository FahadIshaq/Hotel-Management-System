package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class Lunch extends Food implements Serializable {
    private int choice;
    private int Quantity;
    public Lunch() {
        super();
    }
    public Lunch(double x, int y, int z) {
        super(x);
        choice = y;
        Quantity = z;
        switch(choice) {
            case 1: super.setcost(x * z);
                break;
            case 2: super.setcost(x * z);
                break;
            case 3: super.setcost(x * z);
                break;
        }
    }
    public static String Lunchoptions() {
        return "Lunch options\n1) Chicken Biryani : 200\n2) Chicken karahi, Afghani naan : 500\n3) Shami kebab, pulao : 450";
    }
    Lunch(Lunch x){
        this.setcost(x.getCost());
        this.choice = x.choice;
        this.Quantity = x.Quantity;
    }
    public String tostring() {
        return "\nChoice = "+choice+"\nQuantity = "+Quantity+super.tostring();
    }

}
