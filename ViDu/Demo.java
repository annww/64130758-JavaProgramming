import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo{
    public static void main(String[] args) throws IOException {
        FileOutputStream fout;
        try {
            fout = new FileOutputStream("num.txt");
            // Ghi du lieu vao file
            for(int i = 0; i < 127; i++)
            fout.write(i);
            fout.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File khong ton tai!");
        }
        System.out.println("Done");
    }
}