package threadDemos;

import java.time.Year;

public class ThreadSleep implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"运行了"+i+"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        Thread one = new Thread(threadSleep);
        Thread two = new Thread(threadSleep);
        Thread three = new Thread(threadSleep);
        one.start();
        two.start();
        three.start();
    }
}
