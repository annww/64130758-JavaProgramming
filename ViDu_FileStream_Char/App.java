import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        FileReader fReader = new FileReader("mienTay.txt");
        char buff[] = null;
        buff = new char[10];
        fReader.read(buff);
        // In tung ky tu
        for(int i = 0; i < 10; i++){
            System.out.println(buff[i]);
        }
        // Chuyen thanh chuoi ky tu roi in 
        System.out.println(String.valueOf(buff));
    }
}
