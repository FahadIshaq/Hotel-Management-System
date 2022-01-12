package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class LuxurySingleRoom extends Room implements Serializable {
   protected static int noOfrooms = 10;
    public LuxurySingleRoom() {
        super();
    }
    public static String LuxurySingleRoomDetails() {
        return "NO. OF BEDS: 1 \nA.C Y/N : YES \nFREE DINNER+FREE BREAKFAST: YES \nCHARGES PER NIGHT: 2000\n"+availabilty3();
    }
    public void setnumberofrooms() {
        noOfrooms = noOfrooms - 1;
    }
    public static String availabilty3(){
        return "NUMBER OF ROOMS AVAILABLE : "+noOfrooms;
    }

}
