package io.example.producer2consumer.demo2;

public class Consumer implements Runnable
{
    private String consumer;
    private Storage storage;

    public Consumer(Storage storage,String name)
    {
        this.storage = storage;
        this.consumer=name;
    }

    @Override
    public void run()
    {	while(true){
    	consume(consumer);
	    	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    public void consume(String consumer)
    {
        storage.consume(consumer);
    }

    public Storage getStorage()
    {
        return storage;
    }

    public void setStorage(Storage storage)
    {
        this.storage = storage;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}