//  Лабораторная работа_Работа_10 с файлами Смирнов А.Н.
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File2 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("./1.txt");
        FileWriter writer = new FileWriter("./3.txt");

        while (reader.ready())
        {
            int data = reader.read();
            writer.write(data);
        }

        reader.close();
        writer.close();
    }
}
