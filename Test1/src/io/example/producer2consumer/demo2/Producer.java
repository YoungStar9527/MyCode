package io.example.producer2consumer.demo2;

public class Producer implements Runnable
{
    private String producer;
    private Storage storage;

    public Producer(Storage storage,String name)
    {
        this.storage = storage;
        this.producer=name;
    }

    @Override
    public void run()
    {	
    	while(true){
    		produce(producer);
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    		
    }

    public void produce(String producer)
    {
        storage.produce(producer);
    }

    public String getProducer()
    {
        return producer;
    }

    public void setProducer(String producer)
    {
        this.producer = producer;
    }

    public Storage getStorage()
    {
        return storage;
    }

    public void setStorage(Storage storage)
    {
        this.storage = storage;
    }
}
