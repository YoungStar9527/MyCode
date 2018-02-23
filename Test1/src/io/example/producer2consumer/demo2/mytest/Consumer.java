package io.example.producer2consumer.demo2.mytest;

public class Consumer implements Runnable {
	private Storage storage;
	private String cname;
	public Consumer(Storage storage,String cname){
		this.cname=cname;
		this.storage=storage;
	}
	@Override
	public void run() {
		while(true){
			this.storage.consume(this.cname);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
