package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Message;
import com.revature.util.HibernateUtil;


public class MessageImpl implements MessageDao {

	public List<Message> getAllMessages() {
		List<Message> messages = new ArrayList<Message>();
		Session s = HibernateUtil.getSession();
		messages = s.createQuery("from Message").list();
		s.close();
		System.out.println(messages);
		return messages;
	}

	public void deleteMessage(int id) {
		// TODO Auto-generated method stub
		
	}

	public int insertMessage(Message m) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (Integer) s.save(m);
		tx.commit();
		s.close();
		return result;
		
	}

}
