package cf.justforfun.test;

import java.util.*;

public class Message {
	
	private int id;
	private String message;
	private String author;
	private Date date;

//==================================================================
	public Message(int id,
				   String message,
				   String author,
				   Date date){
	
		this.id = id;
		this.date = date;
		this.author = author;
		this.message = message;
	}
	
	public Message(){}
	
//==================================================================
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
