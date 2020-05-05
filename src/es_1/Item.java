package es_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Item {
	static int item_num = 0;
	int size;
	List<Integer> item_list;
	Semaphore mutex = new Semaphore(1);
	
	public Item(int size) {
		this.size = size;
		item_list = new ArrayList<Integer>();
		
	}
	
	public void set_item() throws InterruptedException {
		while(item_list.size()==0) {
			//System.out.println("Producer in attesa");
			mutex.acquire();
			item_num ++;
			item_list.add(item_num);
			System.out.println("Aggiunto "+item_num);
			mutex.release();
		}
		
		
	}
	
	public void get_item() throws InterruptedException {
		while(item_list.size()!=0) {
			//System.out.println("Consumer in attesa");
			mutex.acquire();
			item_list.remove(0);
			System.out.println("Eliminato "+item_num);
			mutex.release();
		}
		
	}
	
}
