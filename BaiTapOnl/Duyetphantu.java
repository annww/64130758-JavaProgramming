import java.util.ArrayList;
import java.util.Iterator;

public class Duyetphantu {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("PHP");
        list.add("HTML");
        list.add("C++");

        Iterator<String> iterator = list.iterator();
        System.out.println("Cac phan tu co trong list: ");
        while(iterator.hasNext()){
            System.out.println((String) iterator.next());
        }
    }
}

