package controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database.DBConnector;
import models.Post;
import models.User;
public class PostController {
	
	Post post;
	
	
	public ArrayList<Post> allPosts() throws ClassNotFoundException, SQLException {
		ArrayList<Post> posts = new ArrayList<>();
		
		Connection con = DBConnector.getInstance();
		PreparedStatement st = con.prepareStatement("Select * from posts;");
		
		ResultSet result = st.executeQuery();
		
		UserController uc = new UserController();
	
		
		while(result.next()) {
		
			int userID = result.getInt("userID");
		
			String username = uc.findUser(userID).getName();
			
			posts.add (
					new Post(result.getInt("id"), result.getString("title"), result.getString("body"),
							result.getInt("userID"), result.getString("date"), result.getInt("upvote"), result.getInt("downvote")
							, username, result.getInt("level"))
					);
			
		}
		
		return posts;
	}
	
	
	public void submitAPost(Post post) throws ClassNotFoundException, SQLException {
		Connection con = DBConnector.getInstance();
		String query = "INSERT INTO posts set title=? , body=?, userID=?, date=?, upvote=?, downvote=?, level=?;";
		
		PreparedStatement st = con.prepareStatement(query);
		
		
		this.post = post;
		
		st.setString(1, post.getTitle());
		st.setString(2, post.getBody());
		st.setInt(3, post.getUserID());
		st.setString(4, post.getDate());
		st.setInt(5,0);
		st.setInt(6,0);
		st.setInt(7, post.getLevel());
		
		st.executeUpdate();
		
	}
	
	public Post findPost(int id) throws ClassNotFoundException, SQLException {
		this.post = null;
		
		Connection con = DBConnector.getInstance();
		String query = "Select * from posts where id=?";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		
		ResultSet result = st.executeQuery();
		UserController uc = new UserController();
		
		while(result.next()) {
			int userID = result.getInt("userID");
			
			String username = uc.findUser(userID).getName();
			new Post(result.getInt("id"), result.getString("title"), result.getString("body"),
					result.getInt("userID"), result.getString("date"), result.getInt("upvote"), result.getInt("downvote")
					, username, result.getInt("level"));
		}
		
		return this.post;
	}
	
}










