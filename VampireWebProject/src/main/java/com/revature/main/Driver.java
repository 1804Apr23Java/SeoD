package com.revature.main;

import java.util.List;

import org.hibernate.Session;

import com.revature.beans.Message;
import com.revature.beans.Vampire;
import com.revature.dao.MessageDao;
import com.revature.dao.MessageImpl;
import com.revature.dao.VampireDao;
import com.revature.dao.VampireImpl;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		/*
		 * Session s = HibernateUtil.getSession(); System.out.println(s.isOpen());
		 * s.close(); System.out.println(s.isOpen());
		 */

		MessageDao md = new MessageImpl();
		Message m1 = new Message("Dave Brewer", "Brewer@mail.com", "First message");
		md.insertMessage(m1);

		List<Message> lm = md.getAllMessages();
		for (Message m : lm) {
			System.out.println(m);
		}
		
		VampireDao vd = new VampireImpl();
		Vampire v1 = new Vampire("Dracula", 466, "Dracula (1897)");
		vd.insertVampire(v1);
		
		List<Vampire> vl = vd.getAllVampires();
		for (Vampire v : vl) {
			System.out.println(v);
		}
	}
}
