package controllers;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Post;

/**
 * Servlet implementation class ViewNote
 */
public class ViewNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewNote() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")==null) {
			request.setAttribute("errortext", "You must login first");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return ;
		}
		
		int id=0;
		 id =  Integer.parseInt(request.getParameter("id"));
		
		 
		
		if(id==0 ) {
			response.sendRedirect(request.getContextPath());
			return;
		}
//		
		PostController pc = new PostController();
		Post ps=null;
		try {
			 ps = pc.findPost(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ps==null) {
	
			response.sendRedirect(request.getContextPath());
			return;
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("post.jsp");
		request.setAttribute("post", ps);
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
