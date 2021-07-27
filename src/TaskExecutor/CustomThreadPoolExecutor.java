package TaskExecutor;

import java.util.ArrayList;
import java.util.List;

public class CustomThreadPoolExecutor {

    private List<Runnable> taskQueue;
    private Thread[] workerThread;

    int index=0;
    int poolSize;

    public CustomThreadPoolExecutor(int poolSize) {
        this.taskQueue = new ArrayList<>();
        this.workerThread = new Thread[poolSize];
        this.poolSize=poolSize;

        startThreads();
    }

    private void startThreads() {

        for (int i = 0; i < poolSize; i++) {
            int threadId = i;
            workerThread[i] = new Thread(() -> consume(threadId));
            workerThread[i].start();
        }
    }

        private void consume(int threadId){
        while(true) {
            Runnable task;
            System.out.println("Thread " + threadId + " is tryng to pick the task ");
            synchronized (taskQueue) {
                System.out.println("Thread: " + threadId + " has acquired lock");
                while (index == 0) {
                    System.out.println("Thread: " + threadId + " is waiting");
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                index--;
                System.out.println("Thread: " + threadId + " has taken task at index" + index);
                task = taskQueue.get(index);
            }
                task.run();

        }



    }

    public void execute(Runnable task) {
        synchronized (taskQueue) {
            System.out.println("Adding task");
            taskQueue.add(task);
            index++;
            taskQueue.notifyAll();
        }

    }










}
