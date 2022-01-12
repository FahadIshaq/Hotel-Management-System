package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class DeluxeSingleRoom extends Room implements Serializable {
    protected static int noOfrooms = 10;
    public DeluxeSingleRoom() {
        super();
    }
    public static String DeluxeSingleRoomDetails() {
        return "NO. OF BEDS : 1 \nA.C Y/N : NO \nFREE DINNER: NO \nCHARGES PER NIGHT : 1500\n"+availabilty1();
    }
    public void setnumberofrooms() {
        noOfrooms = noOfrooms - 1;
    }
    public static String availabilty1(){
        return "NUMBER OF ROOMS AVAILABLE : "+noOfrooms;
    }

}
