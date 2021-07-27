package TaskExecutor;


import TaskExecutor.model.ScheduledTask;

public class ScheduledExecutorService {

    private ScheduledExecutorQueue queue;
    public ScheduledExecutorService(int poolSize) {
        this.queue = new ScheduledExecutorQueue(poolSize);
    }

    public void schedule(Runnable task ,Long time){
        queue.addScheduledTask(new ScheduledTask(task,time));

    }




}
