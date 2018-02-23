package io.example.producer2consumer.demo2.mytest;

public class RunMain {
	public static void main(String[] args) {
		Storage storage=new Storage();
		new Thread(new Producer(storage,"林镇锋")).start();
		new Thread(new Consumer(storage,"漆定仪")).start();
	}
}
