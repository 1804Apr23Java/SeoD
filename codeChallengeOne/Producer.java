package codeChallengeOne;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread implements Runnable {

	private final LinkedBlockingQueue<Items> basket;
	
	public Producer(LinkedBlockingQueue<Items> basket)
	{
		this.basket = basket;
	}
	@Override
	public void run() {
		Random rand = new Random();
		int y = rand.nextInt(5); //Puts random amount into basket
		if (basket.size() == 0)  
		{
			for (int i = 0; i < y; i++)
			{
				int x = rand.nextInt(10000);
				Items item = new Items(x);
				//System.out.println("Produced Item #: " + item.getNumber());
				try {
					Thread.sleep(i);
					basket.put(item);
					System.out.println("Added Item  #" + item.getNumber());

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


}
