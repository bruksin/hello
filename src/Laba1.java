import java.util.Scanner;

public class Laba1 {
    public static void main(String[] args) {
        int[] a;
        a = new int[3];
        Scanner scan = new Scanner(System.in);
        System.out.println("Программа расчета суммы трех чисел:");
        System.out.print("Введите первое число: ");
        a[0] = scan.nextInt();
        System.out.print("Введите второе число: ");
        a[1] = scan.nextInt();
        System.out.print("Введите третье число: ");
        a[2] = scan.nextInt();
        System.out.println("Сумма чисел = "+summa(a));
    }

    static int summa(int[] a1) {
        return a1[0]+a1[1]+a1[2];
    }
}
