package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class Dinner extends Food implements Serializable {
    private int choice;
    private int Quantity;
    public Dinner() {
        super();
    }
    public Dinner(double x, int y, int z) {
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

    public static String Dinneroptions() {
        return "Dinner options\n1) Mutton Palao : 300\n2) Alu matar Keema, naan : 350\n3) Chicken karahi, naan : 450";
    }

    Dinner(Dinner x){
        this.setcost(x.getCost());
        this.choice = x.choice;
        this.Quantity = x.Quantity;
    }
    public String tostring() {
        return "\nChoice = "+choice+"\nQuantity = "+Quantity+super.tostring();
    }


}
