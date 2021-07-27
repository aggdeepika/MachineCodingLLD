package TaskExecutor.model;

public class ScheduledTask implements Comparable<ScheduledTask> {

    private Runnable task;
    private Long scheduledTime;

    public ScheduledTask(Runnable task, Long scheduledTime) {
        this.task = task;
        this.scheduledTime = scheduledTime;
    }

    public Runnable getTask() {
        return task;
    }

    public ScheduledTask setTask(Runnable task) {
        this.task = task;
        return this;
    }

    public Long getScheduledTime() {
        return scheduledTime;
    }

    public ScheduledTask setScheduledTime(Long scheduledTime) {
        this.scheduledTime = scheduledTime;
        return this;
    }

    @Override
    public int compareTo(ScheduledTask o) {
        return (int) (scheduledTime-o.getScheduledTime());
    }

    @Override
    public String toString() {
        return "ScheduledTask{" +
                "task=" + task +
                ", scheduledTime=" + scheduledTime +
                '}';
    }
}
