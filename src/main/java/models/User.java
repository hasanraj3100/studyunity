package models;

public class User {
	private int id;
	private String name;
	private String username;
	private String institute;
	private String email;
	private int influence;
	private int level;
	
	public User(int id, String name, String username, String institute, String email, int influence, int level) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.level= level;
		this.institute = institute;
		this.email = email;
		this.influence = influence;
	}
	
	public User( String name, String username, String institute, String email, int influence, int level) {
	
		this.name = name;
		this.username = username;
		this.institute = institute;
		this.email = email;
		this.influence = influence;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getInstitute() {
		return institute;
	}

	public String getEmail() {
		return email;
	}

	public int getInfluence() {
		return influence;
	}
	
	public int getLevel() {
		return this.level;
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
	
	
	public String getRank() {
		if(influence>=500) 
			return "Champion";
		else if(influence>=300)
			return "Mentor";
		else if(influence>=250)
			return "Master";
		else if(influence>=200) 
			return "Expert";
		else if(influence>=150) 
			return "Maestro";
		else if(influence>=120)
			return "Contributor";
		else if(influence>=100)
			return  "Enthusiast";
		else if(influence>=80)
			return "Scholar";
		else if(influence>=60)
			return "Explorer";
		
		return "Novice";
	}
	
}
