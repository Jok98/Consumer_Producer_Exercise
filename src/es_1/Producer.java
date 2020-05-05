package es_1;

import java.util.concurrent.Semaphore;

public class Producer extends Thread{
	Item item;
	Semaphore mutex = new Semaphore(1);
	public Producer(Item item) {
		
		this.item = item;
		
	}
	public void run() {
		
		while(true) {
			
			try {
				mutex.acquire();
				item.set_item();
				sleep(1000);
				mutex.release();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
}
