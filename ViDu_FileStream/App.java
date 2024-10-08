import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        FileWriter fWriter;
        fWriter = new FileWriter("mien Tay");
        fWriter.write("Mien tay song nuoc co anh J97 bo con\n");
        fWriter.write("Co bo con duoc nhu nguoi ta khong");

        fWriter.flush();
        fWriter.close();
    }
}
