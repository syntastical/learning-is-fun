import java.util.concurrent.*;

public class ThreadPoolExample {
    private ExecutorService threadPool;
    public ThreadPoolExample() {
        threadPool = Executors.newFixedThreadPool(2);
    }

    public void run() {
        Callable<String> task1 = () -> {
            Thread.sleep(3000);
            return "task1 done";
        };
        Callable<String> task2 = () -> {
            Thread.sleep(3000);
            return "task2 done";
        };

        Future<String> futureTask1 = threadPool.submit(task1);
        Future<String> futureTask2 = threadPool.submit(task2);

    }
}
