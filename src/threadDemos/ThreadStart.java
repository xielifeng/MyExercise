package threadDemos;

public class ThreadStart extends Thread{
    public ThreadStart(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println(getName()+"线程运行第"+i+"次");
        }
    }

    public static void main(String[] args) {
        ThreadStart oneThread = new ThreadStart("线程1");//创建线程1
        ThreadStart twoThread = new ThreadStart("线程2");//创建线程2
        //启动线程
        oneThread.start();
        twoThread.start();
    }
}
