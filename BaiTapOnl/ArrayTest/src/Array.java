import java.util.ArrayList;

public class Array {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();

    list.add("Java");
    list.add("PHP");
    list.add("Python");

    ArrayList<String> listA = new ArrayList<String>();
    listA.addAll(list);

    // show list
    System.out.printf("List A: ");
    showlist(listA);
  }

  public static void showlist(ArrayList<String> list) {
    for(String obj:list){
      System.out.printf("\t" + obj + ",");
    }
    System.out.printf("\n");
  }
}
