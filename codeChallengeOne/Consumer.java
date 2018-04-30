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
		int y = rand.nextInt(3); //Removes random amount of objects in basket
		for (int i = 0; i < y; i++)
		{
			if(basket.size() != 0)
			{
				try {
					int removed = basket.take().getNumber();
					System.out.println("Removed Item #: " + removed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else 
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		//add wait
		//Thread.wait();
		
	}

}
