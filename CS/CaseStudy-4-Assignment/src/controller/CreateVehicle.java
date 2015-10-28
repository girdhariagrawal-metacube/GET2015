package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.TypeVehicle;
import model.Vehicle;

/**
 * Servlet implementation class CreateVehicle
 */
@WebServlet("/CreateVehicle")
public class CreateVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateVehicle() {
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
		
		Vehicle vehicle = new Car();
		vehicle.setCreatedBy("admin");
		vehicle.setMake(Integer.parseInt(request.getParameter("make")));
		vehicle.setModel((String)request.getParameter("model"));
		vehicle.setEngineInCC(Integer.parseInt(request.getParameter("engineCapacity")));
		vehicle.setFuelCapacity(Integer.parseInt(request.getParameter("fuelCapacity")));
		vehicle.setMilage(Double.parseDouble(request.getParameter("milage")));
		vehicle.setPrice(Double.parseDouble(request.getParameter("price")));
		vehicle.setRoadTax(Double.parseDouble(request.getParameter("roadTax")));
		vehicle.setVehicleType(TypeVehicle.CAR);
		DBHandler helper = new DBHandler();
		helper.createVehicle(vehicle);
	}

}
