package manythread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        /**缓存线程池,不限制线程个数,有空闲线程则用空闲线程,无空闲线程则创建新的线程*/
//        ExecutorService exeCache=Executors.newCachedThreadPool();
//        for(Integer i=0;i<100;i++){
//            exs.execute(()->{
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
        /**定长线程池,可控制线程最大并发数,超出长度则在队列中等待*/
        ExecutorService exeFix=Executors.newFixedThreadPool(10);//参数,最大线程数即maximumPoolSize
        for(Integer i=0;i<100;i++){
            exeFix.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        exeFix.shutdown();//不会立即的终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
        //exeFix.shutdownNow();//立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务等线程池所有线程执行完毕后关闭线程池
        /**定长线程池,支持定时及周期性任务执行。*/
       // ScheduledExecutorService schExeSer=Executors.newScheduledThreadPool(10);//参数,核心线程数

        /**单线程化的线程池,有且仅有一个工作线程执行任务,所有任务按照指定顺序执行，即遵循队列的入队出队规则*/
        //ExecutorService exeSingle=Executors.newSingleThreadExecutor();
    }
}
