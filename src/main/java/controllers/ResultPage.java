package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Post;

/**
 * Servlet implementation class ResultPage
 */
public class ResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ResultPage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("topicName");
		int level = Integer.parseInt(request.getParameter("level").toString());
		
		PostController pc = new PostController();
		UserController uc = new UserController();
		
		ArrayList<Post> posts = null;
		
		try {
			posts = pc.allPosts();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		
		request.setAttribute("posts", posts);
		
		int totalPages = (int) Math.ceil((double)posts.size() / 5);
		
		request.setAttribute("totalpage", totalPages);
		request.setAttribute("totalpost", posts.size());
		request.setAttribute("topic", keyword);
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
