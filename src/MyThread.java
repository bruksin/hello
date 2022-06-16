// Лабораторная работа_Многопоточное программирование Смирнов А.Н.
import java.lang.Thread;

public class MyThread {
    public static void main(String[] args) {
        for (int i=0; i<3; i++) {
            new Thread(new MyRunnable()).start();
        }

    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            for (int i=0;i<=100;i++) {
                try {
                    Thread.sleep(i*10);
                    if (i % 10 == 0) System.out.println(i + " из потока " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
