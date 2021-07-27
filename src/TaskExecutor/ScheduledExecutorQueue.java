package TaskExecutor;

import TaskExecutor.model.ScheduledTask;


import java.util.PriorityQueue;

public class ScheduledExecutorQueue {

    private final PriorityQueue<ScheduledTask> scheduledTasks;
    private final Thread[] workerThreads;
    int poolSize;

    public ScheduledExecutorQueue(Integer poolSize) {

       this.scheduledTasks=new PriorityQueue<ScheduledTask>();
       this.workerThreads=new Thread[poolSize];
       this.poolSize=poolSize;

        startThreads();
    }

    private void startThreads(){
        for(int i=0;i<poolSize;i++){
            int threadId=i;
            workerThreads[i]= new Thread(()->consume(threadId));
            workerThreads[i].start();

        }
    }

    private void consume(int threadId){
        ScheduledTask scheduledTask;
        while(true){
            System.out.println("Thread: " +threadId+ " is trying to accuire lock");
            synchronized (scheduledTasks){
                System.out.println("Thread: " + threadId + " has acquired lock");
                while(scheduledTasks.isEmpty()){
                    System.out.println("Thread: " + threadId + " is waiting");
                    try {
                        scheduledTasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                scheduledTask=scheduledTasks.peek();
                if(scheduledTask.getScheduledTime()<=System.currentTimeMillis()){
                    scheduledTask=scheduledTasks.poll();

                    System.out.println("Scheduled task id is "+scheduledTask.toString());
                }

            }
            scheduledTask.getTask().run();
        }
    }

    public void addScheduledTask(ScheduledTask task) {
        synchronized (scheduledTasks) {
            System.out.println("Add task to queue: " + task);
            scheduledTasks.add(task);
            scheduledTasks.notifyAll();
        }
    }
}
