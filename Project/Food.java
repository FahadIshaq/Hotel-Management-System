package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class Food implements Serializable {
   private double cost;

    public double getCost() {
        return cost;
    }

    public Food() {

    }
    public Food(double x) {
        cost = x;
    }
    public void setcost(double x) {
        cost = x;
    }
    public double getcost() {
        return cost;
    }
    public String tostring() {
        return "\nPrice = "+cost;
    }

}
