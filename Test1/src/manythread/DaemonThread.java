package manythread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class MyDaemonThread implements Runnable{
    @Override
    public void run() {
        System.out.println("进入守护线程");
            try {
                write();
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("退出守护线程");
    }
    private void write( ) throws  Exception{
        Integer count=0;
        File file= new File("d:"+ File.separator+"123.txt");
        while (count<999){
            OutputStream os=new FileOutputStream(file,true);
            os.write(("\r\n"+count).getBytes());
            System.out.println("守护线程写入"+Thread.currentThread().getName()+"\t"+count++);
            Thread.sleep(1000);
        }
    }
}
public class DaemonThread {
    public static void main(String[] args) {
        System.out.println("程序进入主线程");
        Thread thread=new Thread(new MyDaemonThread());
        thread.setDaemon(true);//线程启动之前将该线程设为守护线程
        thread.start();
        Scanner sc=new Scanner(System.in);
        sc.next();
        System.out.println("程序退出主线程");
    }
}
