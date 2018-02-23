package io.example.producer2consumer.demo2.mytest;

import java.util.LinkedList;

public class Storage {
	/*Inteher 不能做对象锁,原因是Java的自动封箱和解箱操作在作怪。
	 * 这里的i++实际上是i = new Integer(i+1)，所以执行完i++后，i已经不是原来的对象了，同步块自然就无效了*/
	private final Integer maxSize=100;
	private LinkedList<Object> currentNum=new LinkedList<>();
	public void product(String pname){
		synchronized(currentNum){
			while(maxSize==currentNum.size()){
				try {
					currentNum.wait();
					System.out.println("仓库已满,停止生产");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			currentNum.add(new Object());
			System.out.println(pname+":生产了一个商品\t"+"仓库数量为:"+currentNum.size());
			currentNum.notify();
		}
	}
	public void consume(String cname){
		synchronized(currentNum){
			while(currentNum.size()==0){
				try {
					currentNum.wait();
					System.out.println("仓库已空,停止消费");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			currentNum.remove();
			System.out.println(cname+":消费了一个商品\t"+"仓库数量为:"+currentNum.size());
			currentNum.notify();
		}
	}
}
