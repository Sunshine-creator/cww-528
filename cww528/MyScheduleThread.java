package cww528;
import org.omg.CORBA.PUBLIC_MEMBER;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;
public class MyScheduleThread {
    private   Thread[] threads; //员工
    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();   //仓库
    public  MyScheduleThread(int capacity){
        threads= new MyTimer[capacity];
        for (int i = 0; i <capacity ; i++) {
            threads[i] = new MyTimer(queue);
            threads[i].start();
        }
    }
//    public void schedule(Runnable runnable,long delay,long period){   //，任务，延迟时间，间隔时间
//        MyTimerTask task = new MyTimerTask(runnable,new Date().getTime() +delay,period);
//            queue.put(task);
//    }
    private  static  class MyTimer extends Thread{
        private PriorityBlockingQueue<MyTimerTask> queue;
        public MyTimer(PriorityBlockingQueue<MyTimerTask> queue) {
            this.queue=queue;
        }
        @Override
        public void run() {
//            super.run();
              while (true){
//                  try {
//                      synchronized (queue){
//                          long current=System.currentTimeMillis();
//                          if(current<task.next){
//                              queue.wait(task.next-current);
//                          }
//                          task.run();
//                          if(task.period > 0){
//                              task.next = task.next + task.period;
//                              queue.put(task);
//                          }
//                      }
//                  } catch (InterruptedException e) {
//                      e.printStackTrace();
//                  }
              }
        }
    }
    private  static class MyTimerTask implements Runnable,Comparable<MyTimerTask>{    //定时任务，
        private  Runnable runnable;
        private  long next; //下次执行时间
        private  long period;   //间隔时间

        public MyTimerTask(long l, long period) {
            this.next=next;
            this.period=period;
        }

        @Override
        public void run() {
            runnable.run();
        }
        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next,o.next);
        }
    }
}
