package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import models.Post;

/**
 * Servlet implementation class ShareFilePage
 */

@MultipartConfig (
		fileSizeThreshold = 1024*1024*1,
		maxFileSize = 1024*1024*20,
		maxRequestSize = 1024*1024*50,
		location = "C:\\Users\\FC\\eclipse-workspace\\studyunity\\src\\main\\files"
		
		)

public class ShareFilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShareFilePage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("errortext", "You must login first");
			rd.forward(request, response);
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userID = Integer.parseInt( session.getAttribute("userID").toString());
		Post post=null;
		PostController pc = new PostController();
		
		String title = request.getParameter("title");
		String body = request.getParameter("textbox");
		int level = Integer.parseInt(request.getParameter("level"));
		
		post = new Post(1, title, body, userID, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), 0, 0, level);
		
		try {
			pc.submitAPost(post);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Part x = request.getPart("level");
		
	//	String pp = x.getHeader("content-disposition");
		
	//	System.out.println("PP: " + pp);
		
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		
		System.out.println("Filename: " + fileName);
		
		filePart.write(fileName);
		
		
		
		
		
	}

}
