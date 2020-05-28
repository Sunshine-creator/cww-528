package cww528;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolTest {
    private  static ExecutorService pool = Executors.newFixedThreadPool(4);
    private  static ScheduledExecutorService service =Executors.newScheduledThreadPool(5);
    public static  void runFixedThreadPool(Runnable task){
        pool.execute(task);
    }
    public static void main(String[] args) {
        runFixedThreadPool(()->{
            System.out.println("送快递到北京！");
        });
        runFixedThreadPool(()->{
            System.out.println("送快递到上海！");
        });
        System.out.println("自己送！");
         service.scheduleAtFixedRate(()->{     //延迟多少秒在执行
//
             Date date = new Date();
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //{
//                 @Override
//                 public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
//                     return null;
//                 }
//
//                 @Override
//                 public Date parse(String source, ParsePosition pos) {
//                     return null;
//                 }
//             }
             System.out.println(df.format(date));
         },1,2, TimeUnit.SECONDS);
//             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        service.scheduleAtFixedRate(()->{
            System.out.println("abc");
        },0,2,TimeUnit.SECONDS);

    }
}
