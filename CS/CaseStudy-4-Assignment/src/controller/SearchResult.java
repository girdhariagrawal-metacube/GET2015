package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Car;
import model.Vehicle;

/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResult() {
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
		DBHandler handler = new DBHandler();
		String details = (String) request.getParameter("detail");
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		ResultSet result = handler.searchVehicle(details);
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			while(result.next()) {
				
				Vehicle vehicle = new Car();
				vehicle.setVehicleId(result.getInt(1));
				vehicle.setMake(result.getInt(2));
				vehicle.setModel(result.getString(3));
				vehicle.setEngineInCC(result.getInt(4));
				vehicle.setFuelCapacity(result.getDouble(5));
				vehicle.setMilage(result.getDouble(6));
				vehicle.setPrice(result.getDouble(7));
				vehicle.setRoadTax(result.getDouble(8));
				vehicleList.add(vehicle);
			}
			if(session.getAttribute("user") == "admin")
				dispatcher = request.getRequestDispatcher("./view/searchresult.jsp");
			else
				dispatcher = request.getRequestDispatcher("./view/searchresultuser.jsp");
			request.setAttribute("detail", vehicleList);
			request.setAttribute("visible", "visible");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
