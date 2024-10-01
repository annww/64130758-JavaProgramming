import java.util.HashMap;
import java.util.Scanner;

public class MainApp{
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<String,String>();
        dictionary.put("hello","xin chao");
        dictionary.put("goodmorning","chao buoi sang");
        dictionary.put("meet","gap");
        dictionary.put("goodbye","tam biet");
        dictionary.put("miss","nho");
        dictionary.put("you","ban");
        dictionary.put("fine","khoe");
        dictionary.put("hungry","doi");
        dictionary.put("lazy","luoi");
        dictionary.put("sleep","ngu");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a English word: ");
        String translate_word = scanner.next();

        if(dictionary.containsKey(translate_word)){
            System.out.println("Dich: " + dictionary.get(translate_word));
        }
        else {
            System.out.println("Word not found in the dictionary.");
        }
    }    
}
