package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class LuxuryDoubleRoom extends Room implements Serializable {
   protected static int noOfrooms = 10;
    public LuxuryDoubleRoom() {
        super();
    }
    public static String LuxuryDoubleRoomDetails() {
        return "NO. OF BEDS: 2 \nA.C Y/N : YES \nFREE DINNER+ FREE BREAKFAST: YES \nCHARGES PER NIGHT: 4000\n"+availabilty4();
    }
    public int getnor() {
        return noOfrooms;
    }
    public void setnumberofrooms() {
        noOfrooms = noOfrooms - 1;
    }
    public static String availabilty4(){
        return "NUMBER OF ROOMS AVAILABLE : "+noOfrooms;
    }

}
