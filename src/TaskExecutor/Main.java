package TaskExecutor;

public class Main {

    public static void main(String args[]){

      /*  CustomThreadPoolExecutor customThreadPoolExecutor= new CustomThreadPoolExecutor(5);
        customThreadPoolExecutor.execute(new Task());
        customThreadPoolExecutor.execute(new Task());
        customThreadPoolExecutor.execute(new Task());
        customThreadPoolExecutor.execute(new Task());
        customThreadPoolExecutor.execute(new Task());
        customThreadPoolExecutor.execute(new Task());*/

        ScheduledExecutorService scheduledService=new ScheduledExecutorService(2);
        scheduledService.schedule(new Task(), 1L);
        scheduledService.schedule(new Task(), 2L);




    }
}

class Task implements  Runnable{

    @Override
    public void run() {

        System.out.println("Deepika");
      /*  try {
            System.out.println("Wait started");
            Thread.sleep(10000);
            System.out.println("Wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
