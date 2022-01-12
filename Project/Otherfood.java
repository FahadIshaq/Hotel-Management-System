package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class Otherfood extends Food implements Serializable {
   private int choice;
    private int Quantity;
    public Otherfood() {
        super();
    }
    public Otherfood(double x, int y, int z) {
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

    public static String Otherfoodoptions() {
        return "OTHER FOOD OPTIONS\n1) CHICKEN SANDWICH : 100\n2) TEA+CHOCOLATE : 50\n3) COLD DRINK : 100\n4) PIZZA : 1500";
    }

    Otherfood(Otherfood x){
        this.setcost(x.getCost());
        this.choice = x.choice;
        this.Quantity = x.Quantity;
    }
    public String tostring() {
        return "\nCHOICE : "+choice+"\nQUANTITY : "+Quantity+super.tostring();
    }

}
