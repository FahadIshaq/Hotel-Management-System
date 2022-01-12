package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class Breakfast extends Food implements Serializable {
    private int choice;
    private int Quantity;
    public Breakfast() {
        super();
    }
    public Breakfast(double x, int y, int z) {
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

    public static String Breakfastoptions() {
        return " BREAKFAST OPTIONS\n1) BOILED EGG, TEA, NUTELLA PANCAKE: 300\n2) GREEK YOGURT, BREAD, COFFEE, CHIA SEEDS : 400\n3) SANDWICH, COFFEE : 250";
    }

    Breakfast(Breakfast x){
        this.setcost(x.getCost());
        this.choice = x.choice;
        this.Quantity = x.Quantity;
    }
    public String tostring() {
        return "\nCHOICE : "+choice+"\nQUANTITY : "+Quantity+super.tostring();
    }

}
