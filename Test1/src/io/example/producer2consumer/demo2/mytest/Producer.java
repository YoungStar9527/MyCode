package io.example.producer2consumer.demo2.mytest;

public class Producer implements Runnable {
	private Storage storage;
	private String pname;
	public Producer(Storage storage,String pname){
		this.storage=storage;
		this.pname=pname;
	}
	@Override
	public void run() {
		while(true){
			this.storage.product(this.pname);
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}
