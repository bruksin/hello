import java.io.*;
import java.nio.charset.StandardCharsets;

public class Files1 {
    public static void main(String[] args) {
        try {
            File file = new File("./1.txt");
            FileOutputStream  fis = new FileOutputStream (file);
            String message = "Сообщение для первого файла";
            fis.write(message.getBytes(StandardCharsets.UTF_8));
            fis.close();

            File file2 = new File("./2.txt");
            FileOutputStream  fis2 = new FileOutputStream (file2);
            String message2 = "Java — строго типизированный\n" +
                    "объектно-ориентированный язык программирования общего назначения,\n" +
                    "разработанный компанией Sun Microsystems. \n" +
                    "Разработка ведётся сообществом, \n" +
                    "организованным через Java Community Process; \n" +
                    "язык и основные реализующие его технологии распространяются по лицензии GPL";
            fis2.write(message2.getBytes(StandardCharsets.UTF_8));
            fis2.close();

            FileInputStream fis3 = new FileInputStream(file2);
            InputStreamReader isr = new InputStreamReader(fis3, "UTF-8");
            int i;
            while((i=isr.read())!= -1){
                System.out.print((char)i);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
