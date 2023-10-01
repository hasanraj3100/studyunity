package models;

import java.util.Date;

public class Post {
	
	private int id;
	private String title;
	private String body;
	private int userID;
	private String date;
	private int upvotes;
	private int downvotes;
	private String userName;
	private int level;
	
	public Post(int id, String title, String body, int userID, String date, int upvotes, int downvotes, int level) {
		
		this.id = id;
		this.title = title;
		this.body = body;
		this.userID = userID;
		this.date = date;
		this.upvotes = upvotes;
		this.downvotes = downvotes;
		this.level = level;
	}
	
public Post(int id, String title, String body, int userID, String date, int upvotes, int downvotes, String userName, int level) {
		
		this.id = id;
		this.title = title;
		this.body = body;
		this.userID = userID;
		this.date = date;
		this.upvotes = upvotes;
		this.downvotes = downvotes;
		this.userName = userName;
		this.level = level;
	}


	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getBody() {
		return body;
	}


	public int getUserID() {
		return userID;
	}


	public String getDate() {
		return date;
	}


	public int getUpvotes() {
		return upvotes;
	}


	public int getDownvotes() {
		return downvotes;
	}

	public String getUserName() {
		return userName;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getLevelString() {
		
		switch(this.level) {
			case 1:
				return "School";
			case 2:
				return "High School";
			case 3:
				return "College";
			case 4:
				return "University";
		}
		
		return "Invalid";
	}
	

}
