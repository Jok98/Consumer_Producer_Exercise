package es_1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Store {
	static int size = 4;
	static Item item = new Item(size);
	public static void main(String[]Args) {
		Executor exe = Executors.newCachedThreadPool();
		
		exe.execute(new Producer(item));
		exe.execute(new Consumer(item));
	}
	
}
