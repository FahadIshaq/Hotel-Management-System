package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public abstract class Room implements Serializable {

    private int roomno;

    public int getRoomno() {
        return roomno;
    }
    int noofdaysofstay;
    double roomfare;
    boolean hastv;
    boolean haswifi;

    public Room() {

    }
    public Room(int w,  double u, boolean y, boolean z) {
        noofdaysofstay = w;
        roomfare = u;
        hastv = y;
        haswifi = z;
    }
    public void setroomno(int x) {
        roomno = x;
    }
    public void setnoofdaysofstay(int x) {
        noofdaysofstay = x;
    }
    public void setroomfare(int x) {
        roomfare = x;
    }
    public void sethastv(boolean x) {
        hastv = x;
    }
    public void sethaswifi(boolean x) {
        haswifi = x;
    }
    public int getroomno() {
        return roomno;
    }
    public double getroomfare() {
        return roomfare;
    }
    public String tostring() {
        return "ROOM NUMBER : "+roomno+"\nTV AVAILABLE : "+hastv+"\nWIFI AVAILABLE : "+haswifi+"\nROOM CHARGES : "+roomfare;
    }
    public abstract void setnumberofrooms();

}
