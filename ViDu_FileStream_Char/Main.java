import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fWriter;
        fWriter = new FileWriter("mienTay");
        fWriter.write("Mien tay song nuoc co anh J97 bo con\n");
        fWriter.write("Co bo con duoc nhu nguoi ta khong");

        fWriter.flush();
        fWriter.close();
    }
}
