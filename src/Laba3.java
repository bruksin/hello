//Лабораторная работа 1_Массивы_Циклы Смирнов АН
public class Laba3 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int proizvedenie = 1;
        for (int i=0;i<9;i++) {
            proizvedenie *= a[i];
        }

        System.out.println("Произведение = " + proizvedenie);

    }
}
