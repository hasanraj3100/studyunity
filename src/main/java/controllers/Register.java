package controllers;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String inst = request.getParameter("institute");
		int level = Integer.parseInt(request.getParameter("level"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(fullName, username, inst, email, 0, level);
		
		UserController uc = new UserController();
		int success = -1;
		try {
			 success = uc.registerUser(user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(success==1) {
			response.sendRedirect("login");
		} else if(success==2) {
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			request.setAttribute("errortext", "User name already exists");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			request.setAttribute("errortext", "Unexpected Error Occured");
			rd.forward(request, response);
		}
	}

}
