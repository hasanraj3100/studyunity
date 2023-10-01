package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnector;
import models.User;

public class UserController {
	private User user;
	
	
	public User authenticateUser(String userName, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DBConnector.getInstance();
		String query = "Select * from users where username=? and password=?;";
		
		PreparedStatement st = con.prepareStatement(query);
		
		
		st.setString(1, userName);
		st.setString(2, password);
		
		ResultSet result = st.executeQuery();
		
		while(result.next()) {
			user = new User(result.getInt("id"), result.getString("name"), result.getString("username"), 
					result.getString("institute"), result.getString("email"), result.getInt("influence"), result.getInt("level"));
		}
		
		
		return user;
	}
	
	public int registerUser(User user, String password ) throws ClassNotFoundException, SQLException {
		
		if(userExists(user.getUsername())) {
			return 2;
		}
		
		this.user = user;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DBConnector.getInstance();
		
		String query = "Insert into users set name=?, institute=?, email=?, username=?, password=?, influence=?, level=?;";
		
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, user.getName());
		st.setString(2, user.getInstitute());
		st.setString(3, user.getEmail());
		st.setString(4, user.getUsername());
		st.setString(5, password);
		st.setInt(6, user.getInfluence());
		st.setInt(7, user.getLevel());
		
		int x = st.executeUpdate();
		
		if(x==1) return 1;
		return 0;
		
		
	}
	
	public boolean userExists(String userName ) throws ClassNotFoundException, SQLException {
		
		Connection con = DBConnector.getInstance();
		String query = "Select * from users where username=?;";
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, userName);
		
		ResultSet result = st.executeQuery();
		
		while(result.next()) {
			return true;
		}
		
		
		return false;
	}
	
	public User findUser(int id) throws ClassNotFoundException, SQLException {
		Connection con = DBConnector.getInstance();
		String query = "Select * from users where id=?;";
		
		PreparedStatement st = con.prepareStatement(query);
		
		
		st.setInt(1, id);
		
		ResultSet result = st.executeQuery();
		
		while(result.next()) {
			user = new User(result.getInt("id"), result.getString("name"), result.getString("username"), 
					result.getString("institute"), result.getString("email"), result.getInt("influence"), result.getInt("level"));
		}
		
		
		return user;
	}
	
	
}
