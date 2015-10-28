package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBHandler handler = new DBHandler();
		User user = new User();
		HttpSession session = request.getSession();
		user.setName((String) request.getParameter("name"));
		user.setPassword((String) request.getParameter("password"));
		if(handler.isUserExist(user)) {
			
			if(user.getName().equalsIgnoreCase("admin") ) {
				session.setAttribute("user", "admin");
				response.sendRedirect("Console");
				
			} else {
				session.setAttribute("user", (String) request.getParameter("name"));
				response.sendRedirect("WelcomeUser");
			}
		} else {
			System.out.println("User doesn't exist!!");
			response.sendRedirect("Home");
		}
	}

}
