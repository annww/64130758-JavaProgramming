import java.util.ArrayList;

public class TimKiemPhanTu {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String> ();
        list.add("Java");
        list.add("PHP");
        list.add("Python");
        list.add("C++");

        System.out.println(list.contains("PHP"));
        System.out.println(list.contains("Adr"));
    }
}
