package Bai6_Citizen;

public class MainApp {
    public static void main(String[] args) {
        OOPCitizen c1= new OOPCitizen(null, null, null, null, null);
        c1.setId("007");
        c1.setName("Mina");
        c1.setGender("male");
        c1.setNation("UK");
        c1.setYear("2004");
        System.out.println(c1.toString());

        OOPCitizen c2= new OOPCitizen(null, null, null, null, null);
        c2.setId("01");
        c2.setName("Hoa");
        c2.setGender("female");
        c2.setNation("Japan");
        c2.setYear("2000");
        System.out.println(c2.toString());

    }
    
}
