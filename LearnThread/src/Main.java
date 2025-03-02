import java.util.ArrayList;
import java.util.List;

public class Main {

    static class MyThread implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("Hello from "+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.setDaemon(true);
        thread.start();
        System.out.println("Hello from "+Thread.currentThread().getName());
    }
}