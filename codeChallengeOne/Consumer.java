package codeChallengeOne;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread implements Runnable {

	private final LinkedBlockingQueue<Items> basket;
	
	public Consumer(LinkedBlockingQueue<Items> basket)
	{
		this.basket = basket;
	}
	
	@Override
	public void run() {
		Random rand = new Random();
		//int y = rand.nextInt(3); //Removes random amount of objects in basket
		int y = 1;
		for (int i = 0; i < y; i++)
		{
			if(basket.size() != 0)
			{
				try {
					int removed = basket.take().getNumber();
					System.out.println("Consumed Item #: " + removed);
				} catch (InterruptedException e) {
					System.out.println("ouch1");
					e.printStackTrace();
				}
			}
			else 
			{
				try {
					System.out.println("Sleeping");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("ouch2");
					e.printStackTrace();
				}
			}
		}
		//add wait
		//Thread.wait();
	}
	

}
