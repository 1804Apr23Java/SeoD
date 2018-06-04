package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Coffee;
import com.revature.client.CoffeeClient;

public class Driver {

	public static void main(String[] args) {
		
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		CoffeeClient cc = ac.getBean("coffeeClient", CoffeeClient.class);
		cc.setResourceUrl("https://dseo5562codechallenge6.cfapps.io/");
		
		Coffee f = cc.getCoffee();		
		System.out.println(f);
		ac.close();
	}

}
