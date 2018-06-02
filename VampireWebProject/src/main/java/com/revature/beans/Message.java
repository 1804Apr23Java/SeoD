package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Message")
public class Message implements Serializable {

	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1171497088660312748L;


	public Message(int messageId, String name, String email, String messageContent) {
		super();
		this.messageId = messageId;
		this.name = name;
		this.messageContent = messageContent;
	}
	
	public Message(String name, String email, String messageContent) {
		super();
		this.name = name;
		this.email = email;
		this.messageContent = messageContent;
	}
	
	public Message() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="messageSequence")
	@SequenceGenerator(allocationSize=1,name="messageSequence",sequenceName="SQ_MESSAGE_PK")
	@Column(name="MESSAGE_ID")
	public int messageId;
	
	@Column(name="NAME")
	public String name;
	
	@Column(name="EMAIL")
	public String email;
	
	@Column(name="CONTENT")
	public String messageContent;
	
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", name=" + name + ", messageContent=" + messageContent + "]";
	}
	
	
}
