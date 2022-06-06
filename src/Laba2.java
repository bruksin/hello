//  Лаб раб2_Смирнов АН
import java.util.Scanner;

public class Laba2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int secret = 10;
        int popytka;
        System.out.println("Угадай число");
        do {
            System.out.print("Введите число от 1 до 100: ");
            popytka = scan.nextInt();
            if (popytka != secret) {
                System.out.println("Не угадал, Попробуй еще раз!");
            }
        } while (popytka != secret);
        System.out.println("Угадал!!!");
    }
}
