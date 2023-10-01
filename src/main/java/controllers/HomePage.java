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
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HomePage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")==null ) {
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			request.setAttribute("loginPath", request.getContextPath() + "/login");
			request.setAttribute("registerPath", request.getContextPath()+ "/register");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			
			request.setAttribute("gsPath", request.getContextPath() + "/groupstudy");
			request.setAttribute("sharePath", request.getContextPath()+ "/shareMaterial");
			request.setAttribute("profilePath",  request.getContextPath()+ "/profile");
			request.setAttribute("logoutPath", request.getContextPath()+ "/logout");
			
			UserController uc = new UserController();
			User user=null;
			try {
				 user = uc.findUser(Integer.parseInt( session.getAttribute("userID").toString()));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("user", user);
			
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
