package manythread;

public class TestThread {
    public static void main(String[] args) {
        MyDaemonThread de=new MyDaemonThread();
        Thread th= new Thread(de);
        th.start();
    }
}
