package manythread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RunnableCallable {
    public static void main(String[] args) {
        /**实现Runnable接口,计算线程执行时间,对比Callable线程实现方式*/
        long oldTime=System.currentTimeMillis();
        Thread thread=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println((System.currentTimeMillis()-oldTime)/1000);

        /**实现callable接口,利用RunnableFuture的实现类FutureTask来获取返回信息*/
        long oldTimeCall=System.currentTimeMillis();
        FutureTask<String> ft=new FutureTask<>(()-> {
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        });//实现call方法
        Thread thcall=new Thread(ft);
        thcall.start();
        String mess="";
        try {
             mess=ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(mess+(System.currentTimeMillis()-oldTimeCall)/1000);
    }
}
