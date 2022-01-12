package Project;
//GROUP MEMBERS:
// FA20-BCS-017 (FAHAD ISHAQ)
//MINAHIL FATIMA (FA20-BCS-037)

import java.io.Serializable;

public class Laundary implements Serializable {
    private double sprice = 50;
    private double pnprice = 40;
    private  double coatprice = 100;
    private double otherprice = 80;
    private int noOfShirt;
    private int noOfpant;
    private int noOfcoat;
    private int noOfotherprice;
    private  double price;

    Laundary(){


    }

    Laundary(int s1,int s2,int s3, int s4){
        noOfShirt = s1;
        noOfpant = s2;
        noOfcoat = s3;
        noOfotherprice = s4;
    }

    public double calculatePrice(){
        price = noOfShirt*sprice + noOfpant*pnprice + noOfcoat*coatprice + noOfotherprice* otherprice;
        return price;
    }
    public String tostring() {
        return "NUMBER OF SHIRTS : "+noOfShirt+"\nNUMBER OF PANTS : "+noOfpant+"NUMBER OF COATS : "+noOfcoat+"\nTOTAL PRICE : "+calculatePrice();
    }


}
