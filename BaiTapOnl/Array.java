import java.util.ArrayList;

public class Array {  // Changed class name to avoid conflict
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        
        // Using addAll()
        System.out.println("Phuong thuc addAll()");
        System.out.println("-----------------------------");
        
        ArrayList<String> listA = new ArrayList<String>();
        listA.addAll(list);
        

        // Show listA
        System.out.println("list A: ");
        showlist(listA);

        // retainAll
        System.out.println("Phuong thuc retainAll()");
        System.out.println("-----------------------------");
        ArrayList<String> listB = new ArrayList<String>();
        listB.add("Java");
        listA.retainAll(listB);
        System.out.println("list A after retainAll: ");
        showlist(listA);

        // RemoveALL
        System.out.println("Phuong thuc removeAll()");
        System.out.println("------------------------");
        list.removeAll(listB);
        System.out.println("list after remove all: ");
        showlist(list);
    }
    public static void showlist(ArrayList<String> list){
        for(String obj:list){
            System.out.println("\t" + obj);
        }
        System.out.println("\n");
    }
}
