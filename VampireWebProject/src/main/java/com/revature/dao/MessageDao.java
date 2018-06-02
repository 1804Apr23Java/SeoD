package com.revature.dao;

import java.util.List;

import com.revature.beans.Message;

public interface MessageDao {

	public List<Message> getAllMessages();
	
	public void deleteMessage(int id);
	
	public int insertMessage(Message m);
	
}
