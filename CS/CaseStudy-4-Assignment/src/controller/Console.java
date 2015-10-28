package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Console
 */
@WebServlet("/Console")
public class Console extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Console() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null && ((String)session.getAttribute("user")).equalsIgnoreCase("admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/console.jsp");
			dispatcher.forward(request, response);
			
		} else {
			response.sendRedirect("Home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("Fucked!!");
		System.out.println("Chal chutiye!!");
		if(((String)session.getAttribute("user")).equalsIgnoreCase("admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/console.jsp");
			dispatcher.forward(request, response);
			
		} else {
			response.sendRedirect("Home");
		}
	}

}
