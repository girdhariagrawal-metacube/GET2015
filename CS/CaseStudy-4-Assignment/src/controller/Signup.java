package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("password").equals(request.getParameter("cpassword"))) {

			User user = new User();
			user.setName((String) request.getParameter("name"));
			user.setPassword((String) request.getParameter("password"));
			user.setEmail((String) request.getParameter("email"));
			user.setNumber((String) request.getParameter("pNumber"));
			DBHandler handler = new DBHandler();

			if(handler.addUser(user)) {
				request.setAttribute("message", "User created Successfully!");
				response.sendRedirect("Home");
			} else {
				request.setAttribute("message", "User Already Exists!!");
				response.sendRedirect("Home");
			}
		} else {
			request.setAttribute("message", "Password Doesn't match!!	");
			response.sendRedirect("Home");
		}

	}

}
