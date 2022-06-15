//Лабораторная работа_Работа с файлами_Смирнов АН
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Files1 {
    public static void main(String[] args) {
        try {
            File file = new File("./1.txt");
            FileOutputStream  fis = new FileOutputStream (file);
            String message =  "Java — строго типизированный\n" +
                    "объектно-ориентированный язык программирования общего назначения,\n" +
                    "разработанный компанией Sun Microsystems. \n" +
                    "Разработка ведётся сообществом, \n" +
                    "организованным через Java Community Process; \n" +
                    "язык и основные реализующие его технологии распространяются по лицензии GPL";
            fis.write(message.getBytes(StandardCharsets.UTF_8));
            fis.close();

            File file2 = new File("./2.txt");
            FileOutputStream  fis2 = new FileOutputStream (file2);
            String message2 = "Сообщение для первого файла";
            fis2.write(message2.getBytes(StandardCharsets.UTF_8));
            fis2.close();


            FileInputStream fis4 = new FileInputStream(file);
            InputStreamReader fr = new InputStreamReader(fis4, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(fr);
            String newcontent = "";
            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line + line.length());
                newcontent += line + line.length() + "\n";
                line = reader.readLine();
            }
            FileOutputStream  fis3 = new FileOutputStream (file2);
            fis3.write(newcontent.getBytes());


            fis3.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
