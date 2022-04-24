package com.simplilearn.demo;

import java.util.Date;

public class UserEntity {

	private long ID;
    private String name;
    private String feedback;
    private Date date_added;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Date getDateAdded() {
		return date_added;
	}
	public void setDateAdded(Date date_added) {
		this.date_added = date_added;
	}
	@Override
	public String toString() {
		return "UserEntity [ID=" + ID + ", name=" + name + ", feedback=" + feedback + ", date_added=" + date_added + "]";
	}
	
    
}
