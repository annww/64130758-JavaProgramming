import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) throws IOException {
        FileReader fReader = new FileReader("mienTay.txt");
        BufferedReader bReader = new BufferedReader(fReader);
        String dong1 = bReader.readLine();
        System.out.println(dong1);
    }
}
