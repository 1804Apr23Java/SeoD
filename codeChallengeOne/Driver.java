package codeChallengeOne;

import java.util.concurrent.LinkedBlockingQueue;


//https://www.quora.com/Which-collections-are-synchronized-in-Java
//Going with BlockingQueue <-nvm apparently is an interface
public class Driver {
	
	public static void main(String[] args) {
		LinkedBlockingQueue<Items> basket = new LinkedBlockingQueue<Items>();
		
		Producer p1 = new Producer(basket);
		Producer p2 = new Producer(basket);
		Producer p3 = new Producer(basket);
		Consumer c1 = new Consumer(basket);
		Consumer c2 = new Consumer(basket);
		Consumer c3 = new Consumer(basket);
		
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
	    new Thread(c1).start();
	    new Thread(c2).start();
	    new Thread(c3).start();
	}
}
