package com.paragon.quickcast.entity;

public class Message {
	
	private int msg_id;
	
	private int dispatch_id;
	
	private int receive_id;
	
	private String title;
	
	private String content;
	
	private String status;
	
	private String dispatch_time;

	
	
	
	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public int getDispatch_id() {
		return dispatch_id;
	}

	public void setDispatch_id(int dispatch_id) {
		this.dispatch_id = dispatch_id;
	}

	public int getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(int receive_id) {
		this.receive_id = receive_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDispatch_time() {
		return dispatch_time;
	}

	public void setDispatch_time(String dispatch_time) {
		this.dispatch_time = dispatch_time;
	}
}
