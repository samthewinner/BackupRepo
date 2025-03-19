import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

//    static class MyThread implements Runnable{
//
//        @Override
//        public void run() {
//            while (true){
//                System.out.println("Hello from "+Thread.currentThread().getName());
//            }
//        }
//    }

//    for(int i=0;i<subscribers.size();i+=BATCHSIZE){
//        List<Long> batch = new ArrayList<>();
//        for(int j=0;j<Math.min(subscribers.size(),i+100);j++){
//            batch.add(subscribers.get(i+j));
//        }
//        Map<String,Object> msg = new HashMap<>();
//        msg.put("subscribers",batch);
//        msg.put("message",data.get("message"));
//        rabbitMQProducer.sendMessage(objectMapper.valueToTree(msg));
//    }


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        List<Long> subscriber = new ArrayList<>(100);
        for(int i=0;i<10;i++){
            subscriber.add((long)(Math.random()*100));
        }
        System.out.println(subscriber);




        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,5L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
        for(int i=0;i<15;i++){
            final int temp = i;
            threadPoolExecutor.execute(()->{
                try{
                    System.out.println(String.format("Adding batch %d in queue whose current size is %d",temp,threadPoolExecutor.getActiveCount()));
                    Thread.sleep(2000);
                    System.out.println("Work done for batch: "+temp+"Active count: "+threadPoolExecutor.getActiveCount());
                }catch (Exception e){

                    System.out.println(e.getStackTrace());
                }

            });
        }
        System.out.println("Out here----------------------");
        threadPoolExecutor.shutdown();
//        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS); // Wait for tasks to finish


//        long endTime = System.nanoTime();
//        long elapsedTime = endTime - startTime;
//        double elapsedTimeInMillis = elapsedTime / 1_000_000.0;
//        System.out.println(Thread.currentThread().getName());;
//
//        System.out.println("Time taken: " + elapsedTimeInMillis + " milliseconds");

//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.setDaemon(true);
//        thread.start();
//        System.out.println("Hello from "+Thread.currentThread().getName());
    }
}