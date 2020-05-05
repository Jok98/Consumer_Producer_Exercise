package es_1;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
	Item item;
	Semaphore mutex = new Semaphore(1);
	public Consumer(Item item) {
		
		this.item = item;
		
	}
	
	public void run() {
		
		while(true) {
			
			try {
				mutex.acquire();
				item.get_item();
				sleep(1000);
				mutex.release();
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		
	}
	
}
