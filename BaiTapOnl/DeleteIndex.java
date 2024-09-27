import java.util.ArrayList;

public class DeleteIndex {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        // add 
        list.add("Java");
        list.add("PHP");
        list.add("HTML");
        list.add("CSS");

        System.out.println("So phan tu ban dau: " +list);
        System.out.println("Cac phan tu cua list ban dau: " + list.size());

        list.remove(1);
        System.out.println("\nSo phan tu sau khi remove phan tu co index=1: " + list);
        System.out.println("\nCac phan tu sau khi remove phan tu co index = 1: " + list.size());

        list.remove("HTML");
        System.out.println("\nSo phan tu sau khi remove HTML: " + list);
        System.out.println("\nCac phan tu sau khi remove: " + list.size());
    }
}
